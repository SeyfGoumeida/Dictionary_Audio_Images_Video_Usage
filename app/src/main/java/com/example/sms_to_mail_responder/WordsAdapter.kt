package com.example.sms_to_mail_responder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class WordsAdapter(private val words: ArrayList<Word>):
    RecyclerView.Adapter<WordsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var word:Word = words[position]
        holder.name.text = word.name
        holder.name.setOnClickListener {
            holder.name.text = "ra7 el ghali"
        }

    }
    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        var name:TextView = item.findViewById(R.id.word_name)

    }
}