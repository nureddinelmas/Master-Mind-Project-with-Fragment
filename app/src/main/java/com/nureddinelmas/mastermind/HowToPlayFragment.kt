package com.nureddinelmas.mastermind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_how_to_play.*


class HowToPlayFragment : Fragment() {

    var currentPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_how_to_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        exitImageView.setOnClickListener {
           val action = HowToPlayFragmentDirections.actionHowToPlayFragmentToIntroFragment()
            Navigation.findNavController(it).navigate(action)
        }

        backButton.setOnClickListener {

            currentPosition--
            if (currentPosition >=  0){
               when(currentPosition){
                   0-> howToPlayImageView.setImageResource(R.drawable.howtoplay)
                   1-> howToPlayImageView.setImageResource(R.drawable.putimagesone)
                   2-> howToPlayImageView.setImageResource(R.drawable.putimagestwo)
               }
            }else{
                currentPosition = 0

            }
        }

        aheadButton.setOnClickListener {
            currentPosition++
            when(currentPosition){
                0-> howToPlayImageView.setImageResource(R.drawable.howtoplay)
                1-> howToPlayImageView.setImageResource(R.drawable.putimagesone)
                2-> howToPlayImageView.setImageResource(R.drawable.putimagestwo)
            }


        }

    }
}