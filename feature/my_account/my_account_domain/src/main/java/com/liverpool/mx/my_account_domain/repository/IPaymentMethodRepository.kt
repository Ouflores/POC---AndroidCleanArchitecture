package com.liverpool.mx.my_account_domain.repository

import com.liverpool.mx.my_account_domain.models.PaymentMethod

interface IPaymentMethodRepository {
    suspend fun  getLocalPaymentMethods(): List<PaymentMethod>
    suspend fun  getRemotePaymentMethods(): List<PaymentMethod>
}