package com.liverpool.mx.my_account_presentation.my_wallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liverpool.mx.my_account_domain.models.PaymentMethod
import com.liverpool.mx.my_account_presentation.R

class MyWalletAdapter  : RecyclerView.Adapter<MyWalletAdapter.ViewHolder>() {

    var payments: List<PaymentMethod>? = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_title_payment)
        val divider: View =  itemView.findViewById(R.id.divider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_payment_methods, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val payment: PaymentMethod? = payments?.get(position)
        viewHolder.title.text = payment?.name
        if (position == itemCount - 1) {
            viewHolder.divider.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return payments?.size ?: 0
    }

}