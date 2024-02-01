package com.liverpool.mx.my_account_data.data_source.remote.payment_method

import com.liverpool.mx.core_network.dto.payment_method.PaymentMethodResponse

interface IPaymentMethodRemoteDataSource {
    suspend fun getPaymentMethods(): List<PaymentMethodResponse>
}