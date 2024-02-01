package com.liverpool.mx.my_account_presentation.my_wallet.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.liverpool.mx.common.base.scope.ScopedViewModel
import com.liverpool.mx.my_account_domain.use_case.payment_method.GetPaymentMethodsUseCase
import com.liverpool.mx.my_account_presentation.my_wallet.viewState.MyWalletState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyWalletViewModel @Inject constructor(
    private val getPaymentMethodsUseCase: GetPaymentMethodsUseCase
): ScopedViewModel() {

    private val _viewState = MutableLiveData<MyWalletState>()
    val viewState: LiveData<MyWalletState> =  _viewState

    fun setUp() {
        _viewState.value = MyWalletState.ShowLoader
        launch {
            val paymentMethodResponse = getPaymentMethodsUseCase.invoke(true)
            if (paymentMethodResponse.isNotEmpty()) {
                _viewState.value = MyWalletState.DisplayPayments(paymentMethodResponse)
            }
            _viewState.value = MyWalletState.HideLoader
        }
    }
}