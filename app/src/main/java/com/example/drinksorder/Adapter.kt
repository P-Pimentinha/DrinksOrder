package com.example.drinksorder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val drinklist: ArrayList<DrinkModel>): RecyclerView.Adapter<com.example.drinksorder.Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.example.drinksorder.Adapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)

        return MyViewHolder(v)

    }

    override fun getItemCount(): Int {
        return drinklist.size
    }

    override fun onBindViewHolder(holder: com.example.drinksorder.Adapter.MyViewHolder, position: Int) {
        holder.drinkName.setText(drinklist[position].getDrinkName())
        holder.drinkQuantity.setText(drinklist[position].getDrinkQuantity())
        holder.btnAdd.setOnClickListener(){
            drinklist[position].addQUantity()
            holder.drinkQuantity.setText(drinklist[position].getDrinkQuantity())
        }
        holder.btnSUb.setOnClickListener(){
            drinklist[position].subQuantity()
            holder.drinkQuantity.setText(drinklist[position].getDrinkQuantity())
        }
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var drinkName: TextView
        var drinkQuantity: TextView
        var btnAdd : Button
        var btnSUb : Button

        init{
            drinkName = itemView.findViewById(R.id.tvDrinkName)
            drinkQuantity = itemView.findViewById(R.id.tvDrinkQuantity)
            btnAdd = itemView.findViewById(R.id.btnAdd)
            btnSUb = itemView.findViewById(R.id.btnSUb)
        }
    }



}