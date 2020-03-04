package com.bubal93.tcrypto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bubal93.tcrypto.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {
    //create ViewHolder and initialise views for list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_item,
            parent, false
        )
        return CurrencyViewHolder(v)
    }

    //view holder implementation
    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {
        init {
            //listener for item clicks
            itemView.setOnClickListener {
            }
        }

        //bind items to RecyclerView and fill them with data
        override fun bind(item: Any) {
            let {
                item as Currency
                Glide.with(view.context).load(item.image).into(view.ivCurrencyIcon)
                view.tvCurrencySym.text = item.symbol
                view.tvCurrencyName.text = item.name
                view.tvCurrencyMarketCap.text = item.marketCap
                view.tvCurrencyPrice.text = item.price.toString()
            }
        }
    }

    //class for data of list's item
    data class Currency(
        val id: String,
        val symbol: String,
        val name: String,
        val image: String,
        val price: Float,
        val marketCap: String,
        val marketCapRank: Int,
        val totalVolume: Float,
        val priceChangePercentage24h: Float,
        val marketCapChangePercentage24h: Float,
        val circulatingSupply: Double,
        val totalSupply: Long,
        val ath: Float,
        val athChangePercentage: Float
    )
}