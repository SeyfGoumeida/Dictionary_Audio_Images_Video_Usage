package com.example.Dictionary_Audio_Images_Video_Usage.ui.home

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Dictionary_Audio_Images_Video_Usage.R
import com.example.Dictionary_Audio_Images_Video_Usage.Word
import com.example.Dictionary_Audio_Images_Video_Usage.WordsAdapter


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
        var names: MutableList<String> = ArrayList()
        var descriptions: MutableList<String> = ArrayList()
        for(i in resources.getStringArray(R.array.array_words)){
            names.add(i)

        }
        for(i in resources.getStringArray(R.array.array_descriptions)){
            descriptions.add(i)
        }
        var words: MutableList<Word> = ArrayList()
        var cmp:Int =0
        for(i in names){
            var word = Word(i,descriptions[cmp])
            words.add(word)
            cmp++
            listWords.adapter = WordsAdapter(words as ArrayList<Word>,this)
        }





        //--------------------------------------------------------
        return root
    }
    override fun  OnWordItemClick(item:Word, Position:Int, name :TextView, picture:ImageView, description:TextView,
                                  video : VideoView,playBtn : Button){

        name.text="More Info About : "+item.name
        description.text=item.description
        if(description.isVisible){
            description.visibility = View.GONE
            picture.visibility = View.GONE
            name.text=item.name
            video.visibility=View.GONE
            playBtn.visibility=View.GONE

        }
        else{
            description.visibility = View.VISIBLE
            picture.visibility = View.VISIBLE

            if (item.name=="Elon Musk") {
                picture.setImageDrawable(getResources().getDrawable(R.drawable.elon_musk));
                video.visibility=View.VISIBLE
                playBtn.visibility=View.VISIBLE
            }else
                if (item.name=="Bill Gates"){
                    picture.setImageDrawable(getResources().getDrawable(R.drawable.bill_gates));
                    video.visibility=View.VISIBLE
                    playBtn.visibility=View.VISIBLE
                }
                else
                    if(item.name=="Jack Ma"){
                        picture.setImageDrawable(getResources().getDrawable(R.drawable.jack_ma));
                    }
                    else
                        if(item.name=="Steve Jobs"){
                            picture.setImageDrawable(getResources().getDrawable(R.drawable.steve_jobs));
                        }
                        else
                            if(item.name=="Mark Zuckerberg"){
                                picture.setImageDrawable(getResources().getDrawable(R.drawable.mark_zuckerberg));
                            }



        }


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
    override fun  OnPlayItemClick(item:Word, Position:Int,name :TextView,video : VideoView){
        if (item.name=="Elon Musk") {
            val mc = MediaController(activity)
            video.setMediaController(mc)
            val ur = Uri.parse("android.resource://" + activity?.packageName + "/"
                    + R.raw.elon_musk_video) //do not add any extension
            video.setVideoURI(ur)
            video.start()

        }else
            if (item.name=="Bill Gates"){
                val mc = MediaController(activity)
                video.setMediaController(mc)
                val ur = Uri.parse("android.resource://" + activity?.packageName + "/"
                        + R.raw.bill_gates_video) //do not add any extension
                video.setVideoURI(ur)
                video.start()
            }

    }
}
