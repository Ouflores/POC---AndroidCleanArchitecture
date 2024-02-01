package com.liverpool.mx.my_account_data.repository.payment_method

import com.liverpool.mx.my_account_data.data_source.local.payment_method.IPaymentMethodLocalDataSource
import com.liverpool.mx.my_account_data.data_source.remote.payment_method.IPaymentMethodRemoteDataSource
import com.liverpool.mx.my_account_data.mapper.payment_method.toDomain
import com.liverpool.mx.my_account_domain.models.PaymentMethod
import com.liverpool.mx.my_account_domain.repository.IPaymentMethodRepository
import javax.inject.Inject

class PaymentMethodRepositoryImpl @Inject constructor(
    private val localDataSource: IPaymentMethodLocalDataSource,
    private val remoteDataSource: IPaymentMethodRemoteDataSource
): IPaymentMethodRepository {

    override suspend fun getLocalPaymentMethods(): List<PaymentMethod> =
        localDataSource.getPaymentMethods().map { it.toDomain() }

    override suspend fun getRemotePaymentMethods(): List<PaymentMethod> =
        remoteDataSource.getPaymentMethods().map { it.toDomain() }

}