package com.weha.androidroomrx.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weha.androidroomrx.data.model.User
import com.weha.androidroomrx.databinding.ViewUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder>() {
    private val mData = mutableListOf<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<User>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ViewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mData[position])
    }

    inner class Holder(itemView: ViewUserBinding) : RecyclerView.ViewHolder(itemView.root) {
        private var view: ViewUserBinding

        init {
            view = itemView
        }

        fun bind(user: User) {
            view.tvNo.text = "${adapterPosition + 1}."
            view.tvUser.text = user.firstName
        }
    }
}