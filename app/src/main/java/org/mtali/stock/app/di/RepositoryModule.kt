package org.mtali.stock.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mtali.stock.data.csv.CSVParser
import org.mtali.stock.data.csv.CompanyListingsParser
import org.mtali.stock.data.repository.StockRepositoryImpl
import org.mtali.stock.domain.model.CompanyListing
import org.mtali.stock.domain.repository.StockRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsCompanyListingParser(parser: CompanyListingsParser): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindsStockRepository(repo: StockRepositoryImpl): StockRepository
}