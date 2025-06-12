package com.example.project2462.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.project2462.Domain.ItemsModel
import com.example.project2462.Helper.ChangeNumberItemsListener
import com.example.project2462.Helper.ManagmentCart
import com.example.project2462.databinding.ViewholderCartBinding

class CartAdapter(
    private val listItemSelected: ArrayList<ItemsModel>,
    private val context: Context,
    private val changeNumberItemsListener: ChangeNumberItemsListener
) : RecyclerView.Adapter<CartAdapter.Viewholder>() {

    class Viewholder(val binding: ViewholderCartBinding) : RecyclerView.ViewHolder(binding.root)

    private val managmentCart = ManagmentCart(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val adapterPosition = holder.adapterPosition
        if (adapterPosition == RecyclerView.NO_POSITION) return

        val item = listItemSelected[adapterPosition]

        holder.binding.titleTxt.text = item.title
        holder.binding.feeEachItem.text = holder.itemView.context.getString(
            com.example.project2462.R.string.price_format, item.price
        )
        holder.binding.totalEachItem.text = holder.itemView.context.getString(
            com.example.project2462.R.string.total_price_format, item.numberInCart + item.price
        )
        holder.binding.numberItemTxt.text = item.numberInCart.toString()

        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.picCart)

        holder.binding.plusEachItem.setOnClickListener {
            managmentCart.plusItem(listItemSelected, adapterPosition, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyItemChanged(adapterPosition)
                    changeNumberItemsListener?.onChanged()
                }
            })
        }

        holder.binding.minusEachItem.setOnClickListener {
            managmentCart.minusItem(listItemSelected, adapterPosition, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyItemChanged(adapterPosition)
                    changeNumberItemsListener?.onChanged()
                }
            })
        }

        holder.binding.removeItemBtn.setOnClickListener {
            managmentCart.romveItem(listItemSelected, adapterPosition, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyItemRemoved(adapterPosition)
                    notifyItemRangeChanged(adapterPosition, listItemSelected.size)
                    changeNumberItemsListener?.onChanged()
                }
            })
        }
    }

    override fun getItemCount(): Int = listItemSelected.size
}
