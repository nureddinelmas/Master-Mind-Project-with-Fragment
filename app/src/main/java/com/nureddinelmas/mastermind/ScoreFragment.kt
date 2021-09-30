package com.nureddinelmas.mastermind

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_score.*
import android.media.MediaPlayer as MediaPlayer

class ScoreFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences


    private var player : String = ""
    private var yourScore : Int = 0
    private var scoreFromPreferences : Int? = null
    private var playerFromPreferences: String? = null

    lateinit var mediaPlayer: MediaPlayer

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
            textHighPointName.text = "${playerFromPreferences!!.uppercase()}"
            textHighPoint.text  = "$scoreFromPreferences"
        }

        sharedPreferences = requireActivity().getSharedPreferences("com.nureddinelmas.mastermind", Context.MODE_PRIVATE)

        textPlayerName.text = "${player.uppercase()}"
        textPlayerPoint.text = "$yourScore"


        if (yourScore > scoreFromPreferences!!){
            scoreFragmentConstraintLayout.visibility = View.INVISIBLE
            mediaPlayer = MediaPlayer.create(requireContext(),R.raw.winsoundeffect)
            mediaPlayer.start()

            var alert = AlertDialog.Builder(this.requireContext())
            alert.setMessage(":)) CONGRATULATIONS ${player.uppercase()} :)) You are best player :))")
            alert.setPositiveButton("Go to Game Result"){dialog, which ->
                scoreFragmentConstraintLayout.visibility = View.VISIBLE
                textHighPoint.text = "$yourScore"
                textHighPointName.text = "${player!!.uppercase()}"

                sharedPreferences.edit().putInt("score", yourScore).apply()
                sharedPreferences.edit().putString("player", player).apply()
            }
            alert.show()

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