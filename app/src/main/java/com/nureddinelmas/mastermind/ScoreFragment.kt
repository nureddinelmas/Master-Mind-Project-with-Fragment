package com.nureddinelmas.mastermind

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_score.*

class ScoreFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    var playerF : String = ""
    var score : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            playerF = ScoreFragmentArgs.fromBundle(it).player.toString()
           score = ScoreFragmentArgs.fromBundle(it).score

        }

        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        sharedPreferences = requireActivity().getSharedPreferences("com.nureddinelmas.mastermind", Context.MODE_PRIVATE)

        textPlayerName.text = "$playerF ! Your Point :"
        textPlayerPoint.text = "$score"


        playAgainButton.setOnClickListener {
            val action = ScoreFragmentDirections.actionScoreFragmentToOnePlayerFragment(playerF)
            Navigation.findNavController(it).navigate(action)

        }

    }
}