package org.mtali.stock.data.mapper

import org.mtali.stock.data.local.CompanyListingEntity
import org.mtali.stock.data.remote.dto.CompanyInfoDto
import org.mtali.stock.domain.model.CompanyInfo
import org.mtali.stock.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = this.name,
        symbol = this.symbol,
        exchange = this.symbol
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = this.name,
        symbol = this.symbol,
        exchange = this.symbol
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}