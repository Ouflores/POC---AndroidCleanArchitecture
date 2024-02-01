package com.liverpool.mx.my_account_presentation.my_wallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.liverpool.mx.my_account_domain.models.PaymentMethod
import com.liverpool.mx.my_account_presentation.databinding.FragmentMyWalletBinding
import com.liverpool.mx.my_account_presentation.my_wallet.adapter.MyWalletAdapter
import com.liverpool.mx.my_account_presentation.my_wallet.viewModel.MyWalletViewModel
import com.liverpool.mx.my_account_presentation.my_wallet.viewState.MyWalletState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyWalletFragment : Fragment() {

    private var _binding: FragmentMyWalletBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyWalletViewModel by viewModels()
    private lateinit var adapter: MyWalletAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MyWalletAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyWalletBinding.inflate(inflater, container, false)
        viewModel.viewState.observe(viewLifecycleOwner, Observer(::updateViewSate))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (binding.rvPayments.adapter == null) {
            binding.rvPayments.apply {
                adapter = this@MyWalletFragment.adapter
            }
        }
        viewModel.setUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateViewSate(state: MyWalletState) {
        when (state) {
            is MyWalletState.DisplayPayments -> displayPayments(state.payments)
            else -> {}
        }
    }

    private fun displayPayments(payments: List<PaymentMethod>) {
        adapter.payments = payments
        binding.rvPayments.visibility = View.VISIBLE
    }
}