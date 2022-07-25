package org.mtali.stock.presentation.company.detail

import org.mtali.stock.domain.model.CompanyInfo
import org.mtali.stock.domain.model.IntradayInfo

data class CompanyInfoState(
    val stocksInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)