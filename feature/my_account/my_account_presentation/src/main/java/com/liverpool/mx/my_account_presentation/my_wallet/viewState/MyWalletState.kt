package com.liverpool.mx.my_account_presentation.my_wallet.viewState

import com.liverpool.mx.my_account_domain.models.PaymentMethod

sealed class MyWalletState {
    data object ShowEmptyState: MyWalletState()
    data object ShowLoader: MyWalletState()
    data object HideLoader: MyWalletState()
    data class DisplayPayments(val payments: List<PaymentMethod>): MyWalletState()
}