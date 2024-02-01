package com.liverpool.mx.my_account_data.data_source.remote.payment_method

import com.liverpool.mx.core_network.dto.payment_method.PaymentMethodResponse

class PaymentMethodRemoteDataSource: IPaymentMethodRemoteDataSource {

    override suspend fun getPaymentMethods(): List<PaymentMethodResponse> {
        return listOf(
            PaymentMethodResponse(0, "Puntos BBVA Remote"),
            PaymentMethodResponse(0, "Monedero Corporativo Remote"),
            PaymentMethodResponse(0, "Monedero Digital Remote"),
        )
    }

}