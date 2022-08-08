package com.androidpoet.currencyconverter.features.defferable;

import androidx.hilt.work.WorkerAssistedFactory;
import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface PeriodicFetchLatestRates_AssistedFactory extends WorkerAssistedFactory<PeriodicFetchLatestRates> {
}
