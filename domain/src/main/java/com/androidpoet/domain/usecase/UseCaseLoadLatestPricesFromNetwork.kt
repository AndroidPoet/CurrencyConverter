package com.androidpoet.domain.usecase

import com.androidpoet.domain.LatestPricesRepository
import java.util.*

class UseCaseLoadLatestPricesFromNetwork(private val latestPricesRepository: LatestPricesRepository) {
    suspend fun perform(): Date {
        return latestPricesRepository.preloadLatestRates()
    }
}