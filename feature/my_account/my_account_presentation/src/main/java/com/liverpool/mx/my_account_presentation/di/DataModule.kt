package com.liverpool.mx.my_account_presentation.di

import com.liverpool.mx.my_account_data.data_source.local.payment_method.IPaymentMethodLocalDataSource
import com.liverpool.mx.my_account_data.data_source.local.payment_method.PaymentMethodLocalDataSource
import com.liverpool.mx.my_account_data.data_source.remote.payment_method.IPaymentMethodRemoteDataSource
import com.liverpool.mx.my_account_data.data_source.remote.payment_method.PaymentMethodRemoteDataSource
import com.liverpool.mx.my_account_data.repository.payment_method.PaymentMethodRepositoryImpl
import com.liverpool.mx.my_account_domain.repository.IPaymentMethodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun bindPaymentLocalDataSource(): IPaymentMethodLocalDataSource = PaymentMethodLocalDataSource()

    @Singleton
    @Provides
    fun bindPaymentRemoteDataSource(): IPaymentMethodRemoteDataSource = PaymentMethodRemoteDataSource()

    @Singleton
    @Provides
    fun bindPaymentMethodRepository(
        localDataSource: IPaymentMethodLocalDataSource,
        remoteDataSource: IPaymentMethodRemoteDataSource
    ): IPaymentMethodRepository = PaymentMethodRepositoryImpl(localDataSource, remoteDataSource)

}