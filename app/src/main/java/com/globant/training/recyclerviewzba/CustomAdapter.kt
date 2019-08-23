package com.globant.training.recyclerviewzba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globant.training.recyclerviewzba.model.Item
import kotlinx.android.synthetic.main.list_layout.view.*

class CustomAdapter(val itemList:ArrayList<Item>,val listener:AdapterEvents?): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(itemList[position])
        holder.bindListener(listener)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var item:Item

        fun bindItems(item: Item){
            this.item = item
            val resourceId = itemView.context.resources.getIdentifier(item.image,"drawable",itemView.context.packageName)
            itemView.img.setImageResource(resourceId)
            itemView.title.text = item.title
            itemView.subTitle.text = item.subTitle
        }

        fun bindListener(listener: AdapterEvents?){
            view.setOnClickListener {
                listener?.onItemClicked(this.item)
            }
        }
    }

    interface AdapterEvents{
        fun onItemClicked(item:Item)
    }
}