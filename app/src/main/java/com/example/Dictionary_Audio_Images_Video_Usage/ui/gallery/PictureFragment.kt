package com.example.Dictionary_Audio_Images_Video_Usage.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.Dictionary_Audio_Images_Video_Usage.R
import kotlinx.android.synthetic.main.nav_header_main.*

class PictureFragment : Fragment() {

    private lateinit var pictureViewModel: PictureViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        pictureViewModel =
                ViewModelProviders.of(this).get(PictureViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_picture, container, false)

        pictureViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
