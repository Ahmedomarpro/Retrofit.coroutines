package com.chase.kotlincoroutines.adapters

import android.content.Context
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ao.coroutinesretrofit.R
import com.chase.kotlincoroutines.model.User


class PostAdapter(val list: List<User>, val context: Context) : RecyclerView.Adapter<PostAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_post, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView as (R.id.tv_title)
        private val bodyTextView = itemView.find<TextView>(R.id.tv_text)

        fun bind(post: User) {
            titleTextView.text = post.email
            bodyTextView.text = post.name
        }
    }
}