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

    private lateinit var sharedPreferences: SharedPreferences

    private var player : String = ""
    private var yourScore : Int = 0
    private var scoreFromPreferences : Int? = null
    private var playerFromPreferences: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            player = ScoreFragmentArgs.fromBundle(it).player.toString()
            yourScore = ScoreFragmentArgs.fromBundle(it).score
        }



        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = this.requireActivity().getSharedPreferences("com.nureddinelmas.mastermind", Context.MODE_PRIVATE)



        scoreFromPreferences = sharedPreferences.getInt("score", 0)
        playerFromPreferences = sharedPreferences.getString("player","No Player Name")

        if (scoreFromPreferences == 0){
            textHighPoint.text = "0"
            textHighPointName.text = "No Player Name"
        }else{
            textHighPointName.text = "$playerFromPreferences"
            textHighPoint.text  = "$scoreFromPreferences"
        }

        sharedPreferences = this.requireActivity().getSharedPreferences("com.nureddinelmas.mastermind", Context.MODE_PRIVATE)

        textPlayerName.text = "$player"
        textPlayerPoint.text = "$yourScore"


        if (yourScore > scoreFromPreferences!!){

            textHighPoint.text = "$yourScore"
            textHighPointName.text = "$player"
            sharedPreferences.edit().putInt("score", yourScore).apply()
            sharedPreferences.edit().putString("player", player).apply()
        }

        playAgainText.setOnClickListener {
            val action = ScoreFragmentDirections.actionScoreFragmentToOnePlayerFragment(player)
            Navigation.findNavController(it).navigate(action)

        }

        resetScoreText.setOnClickListener {

            textHighPoint.text = "0"
            textHighPointName.text = "No Name"


            scoreFromPreferences = sharedPreferences.getInt("score", -1)
            playerFromPreferences = sharedPreferences.getString("player","No Player Name")

            if (scoreFromPreferences != -1){
                sharedPreferences.edit().remove("player").apply()
                sharedPreferences.edit().remove("score").apply()
            }
        }

    }
}