package com.example.Dictionary_Audio_Images_Video_Usage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView


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
        var picture:ImageView = item.findViewById(R.id.picture_imageView)
        var description:TextView = item.findViewById(R.id.description_textView)
        var video : VideoView = item.findViewById(R.id.videoView);
        var playBtn : Button=item.findViewById(R.id.btnPlay)

        fun initialize(item:Word,action:OnWordItemClickListner){
            name.text=item.name

            name.setOnClickListener {
                action.OnWordItemClick(item,adapterPosition,name,picture,description,video,playBtn)
            }
            pronounce.setOnClickListener {
                action.OnPronounceItemClick(item,adapterPosition)
            }
            playBtn.setOnClickListener {
                action.OnPlayItemClick(item,adapterPosition,name,video)
            }

        }
    }
    interface OnWordItemClickListner{

        fun OnPronounceItemClick(item:Word , Position:Int){

        }
        fun OnWordItemClick(item:Word , Position:Int,name :TextView,picture :ImageView,description :TextView ,video : VideoView,playBtn : Button){

        }
        fun OnPlayItemClick(item:Word , Position:Int,name :TextView,video : VideoView){

        }
    }
}