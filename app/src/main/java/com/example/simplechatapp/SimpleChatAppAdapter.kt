package com.example.simplechatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_view.view.*

class SimpleChatAppAdapter(var msg: List<Message>):RecyclerView.Adapter<SimpleChatAppAdapter.chatViewHolder>() {
    inner class chatViewHolder(view: View):RecyclerView.ViewHolder(view) {/*returns null*/}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chatViewHolder {
        val everyMsg = LayoutInflater.from(parent.context).inflate(R.layout.message_view,parent,false)
        return chatViewHolder(everyMsg)
    }

    override fun onBindViewHolder(holder: chatViewHolder, position: Int) {
        holder.itemView.tvSingleMessage.text = msg[position].messageInput
    }

    override fun getItemCount(): Int {
        return msg.size
    }
}