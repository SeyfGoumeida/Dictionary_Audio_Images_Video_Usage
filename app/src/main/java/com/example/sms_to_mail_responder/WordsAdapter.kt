package com.example.sms_to_mail_responder

import android.app.Activity
import android.graphics.Color
import android.media.MediaPlayer
import android.provider.UserDictionary
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sms_to_mail_responder.ui.home.HomeFragment
import java.security.AccessController.getContext


class WordsAdapter(private val words: ArrayList<Word>, var clickListner: OnWordItemClickListner):
    RecyclerView.Adapter<WordsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.initialize(words[position],clickListner)

    }
    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        var name:TextView = item.findViewById(R.id.word_name)
        var pronounce:Button = item.findViewById(R.id.pronounce_button)
        fun initialize(item:Word,action:OnWordItemClickListner){
            name.text=item.name
            name.setOnClickListener {
                action.OnWordItemClick(item,adapterPosition,name)
            }
            pronounce.setOnClickListener {
                action.OnPronounceItemClick(item,adapterPosition)
            }

        }
    }
    interface OnWordItemClickListner{

        fun OnPronounceItemClick(item:Word , Position:Int){

        }
        fun OnWordItemClick(item:Word , Position:Int,view :TextView){

        }
    }
}