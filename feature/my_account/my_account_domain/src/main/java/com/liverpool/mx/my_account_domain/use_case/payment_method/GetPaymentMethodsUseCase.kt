package com.liverpool.mx.my_account_domain.use_case.payment_method

import com.liverpool.mx.my_account_domain.models.PaymentMethod
import com.liverpool.mx.my_account_domain.repository.IPaymentMethodRepository
import javax.inject.Inject

class GetPaymentMethodsUseCase @Inject constructor(
    private val repository: IPaymentMethodRepository
) {
    suspend operator fun invoke(hasInternetConnection: Boolean): List<PaymentMethod> {
        return if (hasInternetConnection) {
            repository.getRemotePaymentMethods()
        } else {
            repository.getLocalPaymentMethods()
        }
    }
}