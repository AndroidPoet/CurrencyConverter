package com.androidpoet.domain

import com.androidpoet.domain.models.DMLatestRate
import kotlinx.coroutines.flow.Flow
import java.util.*

interface LatestPricesRepository {
    suspend fun preloadLatestRates(): Date
    fun fetchRates(searchKey: String?, input: Double): Flow<List<DMLatestRate>>
}