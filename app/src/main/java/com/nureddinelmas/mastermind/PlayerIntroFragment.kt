package com.nureddinelmas.mastermind


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_player_intro.*

class PlayerIntroFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_player_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animDrawable = playerIntroFragment.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(1)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        playerOneText.visibility= View.INVISIBLE
        playerTwoText.visibility= View.INVISIBLE
        playerOneEditText.visibility= View.INVISIBLE
        playerTwoEditText.visibility= View.INVISIBLE
        inputButton.visibility= View.INVISIBLE

        onePlayerRadioButton.setOnClickListener {
            playerOneText.visibility= View.VISIBLE
            playerTwoText.visibility = View.INVISIBLE
            playerOneEditText.visibility= View.VISIBLE
            playerTwoEditText.visibility = View.INVISIBLE
            inputButton.visibility= View.VISIBLE
            playerOneText.text = "Player Name : "
            playerOneText.textSize = 20f
            playerOneEditText.hint = "Enter Your Name"
            twoPlayerRadioButton.isChecked = false

            inputButton.setOnClickListener {
                val action = PlayerIntroFragmentDirections.actionPlayerIntroFragmentToOnePlayerFragment(playerOneEditText.text.toString())
                Navigation.findNavController(it).navigate(action)

            }
        }

        twoPlayerRadioButton.setOnClickListener {
            playerOneText.visibility= View.VISIBLE
            playerTwoText.visibility= View.VISIBLE
            playerOneEditText.visibility= View.VISIBLE
            playerTwoEditText.visibility= View.VISIBLE
            inputButton.visibility= View.VISIBLE
            playerOneText.textSize = 26f
            playerOneText.text = "Player 1 : "
            playerOneEditText.hint = "Enter a player name"
            onePlayerRadioButton.isChecked = false

            inputButton.setOnClickListener {
                val action = PlayerIntroFragmentDirections.actionPlayerIntroFragmentToTwoPlayerFragment(playerOneEditText.text.toString(),playerTwoEditText.text.toString())
                findNavController().navigate(action)
            }
        }
    }


}