package com.example.sms_to_mail_responder.ui.home

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sms_to_mail_responder.MainActivity
import com.example.sms_to_mail_responder.R
import com.example.sms_to_mail_responder.Word
import com.example.sms_to_mail_responder.WordsAdapter
import kotlinx.android.synthetic.main.item_word.*
import kotlinx.android.synthetic.main.nav_header_main.*

class HomeFragment : Fragment() , WordsAdapter.OnWordItemClickListner {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        var root = inflater.inflate(R.layout.fragment_home, container, false)
        var textView: TextView = root.findViewById(R.id.text_home)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        //---------Recycler View-------------------
        var listWords: RecyclerView = root.findViewById(R.id.listWords)
        listWords.layoutManager = LinearLayoutManager(context)
        var words: MutableList<Word> = ArrayList()
        for(i in resources.getStringArray(R.array.array_words)){
            var word = Word(i)
            words.add(word)
            listWords.adapter = WordsAdapter(words as ArrayList<Word>,this)
        }



        //--------------------------------------------------------
        return root
    }
    override fun  OnWordItemClick(item:Word, Position:Int,view :TextView){

        view.text="Get More Infos About "+item.name+Position

    }
    override fun  OnPronounceItemClick(item:Word, Position:Int){
        lateinit var mediaPlayer : MediaPlayer
        if (item.name=="Elon Musk") {
            mediaPlayer= MediaPlayer.create(activity, R.raw.elon_musk)
        }else
            if (item.name=="Bill Gates"){
                mediaPlayer =MediaPlayer.create(activity, R.raw.bill_gates)
            }
        else
            if(item.name=="Jack Ma"){
                mediaPlayer =MediaPlayer.create(activity, R.raw.jack_ma)
            }
        else
            if(item.name=="Steve Jobs"){
                mediaPlayer =MediaPlayer.create(activity, R.raw.steve_jobs)
            }
        else
            if(item.name=="Mark Zuckerberg"){
                mediaPlayer =MediaPlayer.create(activity, R.raw.mark_zuckerberg)
            }

        mediaPlayer.start()
    }
}
