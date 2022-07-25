package org.mtali.stock.domain.repository

import kotlinx.coroutines.flow.Flow
import org.mtali.stock.domain.model.CompanyInfo
import org.mtali.stock.domain.model.CompanyListing
import org.mtali.stock.domain.model.IntradayInfo
import org.mtali.stock.utils.Resource

interface StockRepository {
    suspend fun getCompanyListings(
        forceRefresh: Boolean = false,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(symbol: String): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo>
}