package com.example.ktoractivityex.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ktoractivityex.databinding.AdapterRecyclerViewBinding
import com.example.ktoractivityex.modelArticle.ModelListItem
import com.squareup.picasso.Picasso

class AdapterArticleList(private var mList: ArrayList<ModelListItem>?) :
    RecyclerView.Adapter<AdapterArticleList.ViewHolder>() {
    class ViewHolder(val binding: AdapterRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList!![position]) {

                Picasso.with(binding.image.context).load(this.image).into(binding.image)
                binding.title.text = this.title

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.description.text =
                        Html.fromHtml(this.content, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    binding.description.text = Html.fromHtml(this.content)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }
}