package com.liverpool.mx.my_account_data.data_source.local.payment_method

import com.liverpool.mx.core_network.dto.payment_method.PaymentMethodResponse

interface IPaymentMethodLocalDataSource {
    suspend fun getPaymentMethods(): List<PaymentMethodResponse>
}