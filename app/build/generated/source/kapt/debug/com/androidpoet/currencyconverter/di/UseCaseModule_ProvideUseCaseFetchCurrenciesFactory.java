// Generated by Dagger (https://dagger.dev).
package com.androidpoet.currencyconverter.di;

import com.androidpoet.domain.CurrenciesRepository;
import com.androidpoet.domain.usecase.UseCaseFetchCurrencies;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UseCaseModule_ProvideUseCaseFetchCurrenciesFactory implements Factory<UseCaseFetchCurrencies> {
  private final UseCaseModule module;

  private final Provider<CurrenciesRepository> currenciesRepositoryProvider;

  public UseCaseModule_ProvideUseCaseFetchCurrenciesFactory(UseCaseModule module,
      Provider<CurrenciesRepository> currenciesRepositoryProvider) {
    this.module = module;
    this.currenciesRepositoryProvider = currenciesRepositoryProvider;
  }

  @Override
  public UseCaseFetchCurrencies get() {
    return provideUseCaseFetchCurrencies(module, currenciesRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideUseCaseFetchCurrenciesFactory create(UseCaseModule module,
      Provider<CurrenciesRepository> currenciesRepositoryProvider) {
    return new UseCaseModule_ProvideUseCaseFetchCurrenciesFactory(module, currenciesRepositoryProvider);
  }

  public static UseCaseFetchCurrencies provideUseCaseFetchCurrencies(UseCaseModule instance,
      CurrenciesRepository currenciesRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideUseCaseFetchCurrencies(currenciesRepository));
  }
}