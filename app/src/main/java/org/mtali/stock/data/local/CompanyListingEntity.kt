package org.mtali.stock.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_listings")
data class CompanyListingEntity(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "exchange") val exchange: String
)