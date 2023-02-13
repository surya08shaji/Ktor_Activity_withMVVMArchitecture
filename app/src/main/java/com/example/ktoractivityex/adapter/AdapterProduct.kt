package com.example.ktoractivityex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ktoractivityex.databinding.AdapterRecyclerViewBinding
import com.example.ktoractivityex.modelProduct.ResponseModel
import com.squareup.picasso.Picasso

class AdapterProduct(private var mList: List<ResponseModel>?) : RecyclerView.Adapter<AdapterProduct.ViewHolder>() {
    class ViewHolder (val binding: AdapterRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList!![position]) {

                Picasso.with(binding.image.context).load(this.image).into(binding.image)
                binding.title.text = this.title
                binding.description.text = this.description
            }
        }
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }
}