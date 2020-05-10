package com.example.sms_to_mail_responder

import android.app.Activity
import android.graphics.Color
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sms_to_mail_responder.ui.home.HomeFragment
import java.security.AccessController.getContext


class WordsAdapter(private val words: ArrayList<Word>, var activity : Activity):
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
        holder.pronounce.setOnClickListener {
            holder.name.setBackgroundColor(Color.parseColor("#ffffff"))
            var mediaPlayer = MediaPlayer.create(activity,R.raw.elon_musk)
            mediaPlayer.start()
        }

    }
    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        var name:TextView = item.findViewById(R.id.word_name)
        var pronounce:TextView = item.findViewById(R.id.pronounce_button)
    }
}