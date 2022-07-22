package org.mtali.stock.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.mtali.stock.data.csv.CSVParser
import org.mtali.stock.data.local.StockDatabase
import org.mtali.stock.data.mapper.toCompanyListing
import org.mtali.stock.data.mapper.toCompanyListingEntity
import org.mtali.stock.data.remote.StockService
import org.mtali.stock.domain.model.CompanyListing
import org.mtali.stock.domain.repository.StockRepository
import org.mtali.stock.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockService,
    val db: StockDatabase,
    val listingParser: CSVParser<CompanyListing>
) : StockRepository {

    private val stockDao = db.dao


    override suspend fun getCompanyListings(
        forceRefresh: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val localListings = stockDao.searchCompanyListings(query)
            emit(Resource.Success(data = localListings.map { it.toCompanyListing() }))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val justLoadFromCache = !isDbEmpty && !forceRefresh
            if (justLoadFromCache) {
                emit(Resource.Loading(isLoading = false))
                return@flow
            }
            val remoteListings = try {
                val response = api.getListings()
                listingParser.parser(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                stockDao.clearCompanyListings()
                stockDao.insertCompanyListings(
                    listings.map { it.toCompanyListingEntity() }
                )
                emit(
                    Resource.Success(stockDao
                        .searchCompanyListings("")
                        .map {
                            it.toCompanyListing()
                        })
                )
                emit(Resource.Loading(isLoading = false))
            }

        }
    }

}