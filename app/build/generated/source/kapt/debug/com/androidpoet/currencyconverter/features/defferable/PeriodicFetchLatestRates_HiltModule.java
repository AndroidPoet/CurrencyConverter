package com.androidpoet.currencyconverter.features.defferable;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = PeriodicFetchLatestRates.class
)
public interface PeriodicFetchLatestRates_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.androidpoet.currencyconverter.features.defferable.PeriodicFetchLatestRates")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      PeriodicFetchLatestRates_AssistedFactory factory);
}
