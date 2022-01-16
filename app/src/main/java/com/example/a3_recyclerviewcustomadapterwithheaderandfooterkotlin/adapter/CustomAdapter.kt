package com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.R
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.model.Member

class CustomAdapter(val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES_VIEW = 1
    private val TYPE_ITEM_NO_VIEW = 2
    private val TYPE_ITEM_FOOTER = 3

    override fun getItemViewType(position: Int): Int {
        if (isHeader(position)) return TYPE_ITEM_HEADER
        if (isFooter(position)) return TYPE_ITEM_FOOTER

        val member = members.get(position)
        return if (member.available == true) TYPE_ITEM_YES_VIEW else TYPE_ITEM_NO_VIEW
    }

    fun isHeader(position: Int): Boolean {
        return position == 0
    }

    fun isFooter(position: Int): Boolean {
        return position == members.size - 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEADER) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_header, parent, false)
            return CustomViewHolderHEADER(view)
        }
        if (viewType == TYPE_ITEM_YES_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_yes, parent, false)
            return CustomViewHolderYES(view)
        }
        if (viewType == TYPE_ITEM_NO_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_no, parent, false)
            return CustomViewHolderNO(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_footer, parent, false)
        return CustomViewHolderFOOTER(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)
        if (holder is CustomViewHolderYES){
            holder.tv_name_yes.setText(member.tv_name)
            holder.tv_tel_number_yes.setText(member.tv_tel_numver)
        }
        if (holder is CustomViewHolderNO){
            holder.tv_name_no.setText(member.tv_name)
            holder.tv_tel_number_no.setText(member.tv_tel_numver)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

     class CustomViewHolderHEADER(view: View) : RecyclerView.ViewHolder(view) {

    }


    class CustomViewHolderYES(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name_yes = view.findViewById<TextView>(R.id.tv_name_yes)
        val tv_tel_number_yes = view.findViewById<TextView>(R.id.tv_tel_number_yes)
    }


    class CustomViewHolderNO(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name_no = view.findViewById<TextView>(R.id.tv_name_no)
        val tv_tel_number_no = view.findViewById<TextView>(R.id.tv_tel_number_no)
    }


    class CustomViewHolderFOOTER(view: View) : RecyclerView.ViewHolder(view) {

    }
}