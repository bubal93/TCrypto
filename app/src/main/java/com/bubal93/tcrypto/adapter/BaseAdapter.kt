package com.bubal93.tcrypto.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//abstract base adapter class
abstract class BaseAdapter<VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {
    //list of elements
    var items: ArrayList<Any> = ArrayList()

    override fun getItemCount(): Int {
        return items.size
    }

    //bind views with items
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItem(position: Int): Any {
        return items[position]
    }

    //add one item
    fun add(newItem: Any) {
        items.add(newItem)
    }

    //add all items
    fun add(newItems: List<Any>) {
        items.addAll(newItems)
    }

    //abstract ViewHolder class
    abstract class BaseViewHolder(protected val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Any)
    }
}