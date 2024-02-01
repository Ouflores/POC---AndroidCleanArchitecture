package com.liverpool.mx.my_account_data.mapper.payment_method

import com.liverpool.mx.core_network.dto.payment_method.PaymentMethodResponse
import com.liverpool.mx.my_account_domain.models.PaymentMethod

fun PaymentMethodResponse.toDomain() = PaymentMethod(name = this.name)