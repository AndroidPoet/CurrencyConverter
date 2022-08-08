package com.androidpoet.domain.usecase


import com.androidpoet.domain.LatestPricesRepository
import com.androidpoet.domain.models.DMLatestRate
import kotlinx.coroutines.flow.Flow

class UseCaseFetchLatestPrices(private val latestPricesRepository: LatestPricesRepository) {
    fun perform(value: String): Flow<List<DMLatestRate>> {
        val input = value.toDoubleOrNull() ?: 0.0
        return latestPricesRepository.fetchRates("", input)
    }
}