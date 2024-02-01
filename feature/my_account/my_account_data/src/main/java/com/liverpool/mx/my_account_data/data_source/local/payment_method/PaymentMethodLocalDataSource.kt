package com.liverpool.mx.my_account_data.data_source.local.payment_method

import com.liverpool.mx.core_network.dto.payment_method.PaymentMethodResponse
import javax.inject.Inject

class PaymentMethodLocalDataSource @Inject constructor(
    /**Todo aqui se tiene que inyectar la DB o el servicio Retrofit) **/
    //private val service: ATGNetworkService
): IPaymentMethodLocalDataSource {

    /**
     * Todo Esto es un ejemplo, realemte deberiamos utilizar el objeto service
     * Todo service.requestGetPaymentMethodsAvailable()
     */
    override suspend fun getPaymentMethods(): List<PaymentMethodResponse> {
        return listOf(
            PaymentMethodResponse(0, "Puntos BBVA"),
            PaymentMethodResponse(0, "Monedero Corporativo"),
            PaymentMethodResponse(0, "Monedero Digital"),
        )
    }
}