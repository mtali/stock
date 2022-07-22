package org.mtali.stock.presentation.company.list

sealed class CompanyListingEvent {
    object Refresh : CompanyListingEvent()
    data class OnSearchQueryChanged(val query: String) : CompanyListingEvent()
}