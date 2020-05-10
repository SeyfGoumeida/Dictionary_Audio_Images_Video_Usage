package com.example.sms_to_mail_responder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sms_to_mail_responder.MainActivity
import com.example.sms_to_mail_responder.R
import com.example.sms_to_mail_responder.Word
import com.example.sms_to_mail_responder.WordsAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
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
        }
        listWords.adapter = WordsAdapter(words as ArrayList<Word>)


        //--------------------------------------------------------

        return root
    }
}
