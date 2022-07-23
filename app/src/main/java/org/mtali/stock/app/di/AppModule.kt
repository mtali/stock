package org.mtali.stock.app.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.mtali.stock.data.local.StockDatabase
import org.mtali.stock.data.remote.StockService
import org.mtali.stock.data.remote.StockService.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStockService(): StockService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .client(
                OkHttpClient()
                    .newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesStockDatabase(app: Application): StockDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            StockDatabase::class.java,
            "stocks.db"
        ).build()
    }
}