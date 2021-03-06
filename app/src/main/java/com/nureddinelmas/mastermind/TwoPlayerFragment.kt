package com.nureddinelmas.mastermind

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_two_player.*
import kotlin.system.exitProcess

class TwoPlayerFragment : Fragment() {
    var one : Boolean =false
    var two : Boolean =false
    var three : Boolean =false
    var four : Boolean =false


    var first : Int = 0
    var second : Int = 0
    var third : Int = 0
    var fourth : Int = 0

    var wrong = 0
    var right = 0


    var dirButton = 1

    private lateinit var player1 : String
    private lateinit var player2 : String
    var player : String = ""
    var playerKontrol : Int = 0

    var imageList = mutableListOf(
        R.drawable.red,
        R.drawable.white,
        R.drawable.blue,
        R.drawable.yellow,
        R.drawable.grayoval,
        R.drawable.grayoval,
        R.drawable.grayoval,
        R.drawable.grayoval
    )


    var imageLook = ArrayList<ResultLook>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            player1 = TwoPlayerFragmentArgs.fromBundle(it).player1.toString()
            player2 = TwoPlayerFragmentArgs.fromBundle(it).player2.toString()
        }

        return inflater.inflate(R.layout.fragment_two_player, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findColor()
        playerChoose()
        button.text = "$player now it??s your turn!"

      /*  constraintTwoPlayer.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_UP -> {
                    oneImageView.setImageResource(R.drawable.question)
                    twoImageView.setImageResource(R.drawable.question)
                    threeImageView.setImageResource(R.drawable.question)
                    fourImageView.setImageResource(R.drawable.question)}
                MotionEvent.ACTION_DOWN -> {
                    oneImageView.setImageResource(first)
                    twoImageView.setImageResource(second)
                    threeImageView.setImageResource(third)
                    fourImageView.setImageResource(fourth)}
            }
            true
        }

       */


        oneImageView.setOnClickListener {
            oneImageView.setImageResource(R.drawable.question)
            one = false

            two = true
            three = true
            four = true

        }

        twoImageView.setOnClickListener {
            twoImageView.setImageResource(R.drawable.question)
            two = false

            one = true
            three = true
            four = true
        }

        threeImageView.setOnClickListener {
            threeImageView.setImageResource(R.drawable.question)
            three = false

            one = true
            two = true
            four = true
        }

        fourImageView.setOnClickListener {
            fourImageView.setImageResource(R.drawable.question)
            four = false

            one = true
            two = true
            three = true
        }


        redImageView.setOnClickListener {
            if (!one){
                oneImageView.setImageResource(R.drawable.red)
                one = true
                oneImageView.tag ="red"
            }
            else if (!two){
                twoImageView.setImageResource(R.drawable.red)
                two=true
                twoImageView.tag = "red"
            }
            else if(!three){
                threeImageView.setImageResource(R.drawable.red)
                three = true
                threeImageView.tag = "red"
            }
            else if(!four){
                fourImageView.setImageResource(R.drawable.red)
                four = true
                fourImageView.tag = "red"
            }
        }

        whiteImageView.setOnClickListener {
            if (!one){
                oneImageView.setImageResource(R.drawable.white)
                one = true
                oneImageView.tag = "white"
            }
            else if (!two){
                twoImageView.setImageResource(R.drawable.white)
                two=true
                twoImageView.tag = "white"
            }
            else if(!three){
                threeImageView.setImageResource(R.drawable.white)
                three = true
                threeImageView.tag = "white"
            }
            else if(!four){
                fourImageView.setImageResource(R.drawable.white)
                four = true
                fourImageView.tag = "white"
            }
        }

        blueImageView.setOnClickListener {
            if (!one){
                oneImageView.setImageResource(R.drawable.blue)
                one = true
                oneImageView.tag = "blue"
            }
            else if (!two){
                twoImageView.setImageResource(R.drawable.blue)
                two = true
                twoImageView.tag = "blue"
            }
            else if(!three){
                threeImageView.setImageResource(R.drawable.blue)
                three = true
                threeImageView.tag = "blue"
            }
            else if(!four){
                fourImageView.setImageResource(R.drawable.blue)
                four = true
                fourImageView.tag = "blue"
            }
        }

        yellowImageView.setOnClickListener {
            if (!one){
                oneImageView.setImageResource(R.drawable.yellow)
                one = true
                oneImageView.tag = "yellow"
            }
            else if (!two){
                twoImageView.setImageResource(R.drawable.yellow)
                two = true
                twoImageView.tag = "yellow"
            }
            else if(!three){
                threeImageView.setImageResource(R.drawable.yellow)
                three = true
                threeImageView.tag = "yellow"
            }
            else if(!four){
                fourImageView.setImageResource(R.drawable.yellow)
                four = true
                fourImageView.tag = "yellow"
            }
        }

        blackImageView.setOnClickListener {
            if (!one){
                oneImageView.setImageResource(R.drawable.black)
                one = true
                oneImageView.tag = "black"
            }
            else if (!two){
                twoImageView.setImageResource(R.drawable.black)
                two = true
                twoImageView.tag = "black"
            }
            else if(!three){
                threeImageView.setImageResource(R.drawable.black)
                three = true
                threeImageView.tag = "black"
            }
            else if(!four){
                fourImageView.setImageResource(R.drawable.black)
                four = true
                fourImageView.tag = "black"
            }
        }

        greenImageView.setOnClickListener {
            if (!one){
                oneImageView.setImageResource(R.drawable.green)
                one = true
                oneImageView.tag = "green"
            }
            else if (!two){
                twoImageView.setImageResource(R.drawable.green)
                two = true
                twoImageView.tag = "green"
            }
            else if(!three){
                threeImageView.setImageResource(R.drawable.green)
                three = true
                threeImageView.tag = "green"

            }
            else if(!four){
                fourImageView.setImageResource(R.drawable.green)
                four = true
                fourImageView.tag = "green"
            }
        }

        button.setOnClickListener{
            checkIt()
            playerChoose()
            button.text = "$player now it??s your turn!"
        }
    }

    private fun checkIt(){

        wrong = 0
        right = 0

        createNewImageList()


        if (imageList[0] != first && imageList[0] != second && imageList[0] != third && imageList[0] != fourth){
            wrong ++

        }

        if (imageList[1] != first && imageList[1] != second && imageList[1] != third && imageList[1] != fourth){
            wrong ++

        }

        if (imageList[2] != first && imageList[2] != second && imageList[2] != third && imageList[2] != fourth){
            wrong ++

        }

        if (imageList[3] != first && imageList[3] != second && imageList[3] != third && imageList[3] != fourth){
            wrong ++

        }

        // Right answer we check
        if (fourth == imageList[3]){
            right += 1
        }

        if (first == imageList[0]){
            right += 1
        }
        if (second == imageList[1]){
            right += 1
        }
        if (third == imageList[2]){
            right += 1
        }

        if (fourth == imageList[3] && first == imageList[0] && second == imageList[1] && third == imageList[2]){

            val alert = AlertDialog.Builder(this.requireContext())
            alert.setTitle("Congratulations ${player.uppercase()} :))")
            alert.setMessage("Do you want to play again?")
            alert.setIcon(R.drawable.gameover)
            alert.setPositiveButton("Yes"){dialog, which ->
                val action = TwoPlayerFragmentDirections.actionTwoPlayerFragmentSelf(player1, player2)
                Navigation.findNavController(this.requireView()).navigate(action)
            }
           alert.setNegativeButton("No"){dialog, which ->

               exitProcess(0)
           }
            alert.show()

        }

        else{
            Snackbar.make(requireView(),"${player.uppercase()}! UNSUCCESSFULLY :(( ", Snackbar.LENGTH_LONG).setAction("Exit?", View.OnClickListener { exitProcess(0) }).show()
            transferToRecyclerView()

            oneImageView.setImageResource(R.drawable.question)
            twoImageView.setImageResource(R.drawable.question)
            threeImageView.setImageResource(R.drawable.question)
            fourImageView.setImageResource(R.drawable.question)
            one = false
            two = false
            three = false
            four = false
        }
    }

    private fun createNewImageList(){

        when(oneImageView.tag){
            "red" -> imageList[0] = R.drawable.red
            "white" -> imageList[0] = R.drawable.white
            "blue" -> imageList[0] = R.drawable.blue
            "yellow" -> imageList[0] = R.drawable.yellow
            "black" -> imageList[0] = R.drawable.black
            "green" -> imageList[0] = R.drawable.green
        }
        when(twoImageView.tag){
            "red" -> imageList[1] = R.drawable.red
            "white" -> imageList[1] = R.drawable.white
            "blue" -> imageList[1] = R.drawable.blue
            "yellow" -> imageList[1] = R.drawable.yellow
            "black" -> imageList[1] = R.drawable.black
            "green" -> imageList[1] = R.drawable.green
        }
        when(threeImageView.tag){
            "red" -> imageList[2] = R.drawable.red
            "white" -> imageList[2] = R.drawable.white
            "blue" -> imageList[2] = R.drawable.blue
            "yellow" -> imageList[2] = R.drawable.yellow
            "black" -> imageList[2] = R.drawable.black
            "green" -> imageList[2] = R.drawable.green
        }
        when(fourImageView.tag){
            "red" -> imageList[3] = R.drawable.red
            "white" -> imageList[3] = R.drawable.white
            "blue" -> imageList[3] = R.drawable.blue
            "yellow" -> imageList[3] = R.drawable.yellow
            "black" -> imageList[3] = R.drawable.black
            "green" -> imageList[3] = R.drawable.green
        }
    }

    private fun  transferToRecyclerView(){
        findBlackWhite()

        imageLook.add(ResultLook(imageList[0], imageList[1], imageList[2], imageList[3], imageList[4], imageList[5], imageList[6],imageList[7],"$player"))
        TwoPlayerRecyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = ResultAdapter(imageLook)
        TwoPlayerRecyclerView.adapter = adapter
    }

    private fun playerChoose() : String{
         playerKontrol++
        player = if (playerKontrol % 2 == 0){
            player1
        }else{
            player2
        }
        return player
    }



    private fun findBlackWhite(){
        imageList[7] = R.drawable.grayoval
        imageList[6] = R.drawable.grayoval
        imageList[5] = R.drawable.grayoval
        imageList[4] = R.drawable.grayoval


        when(right){
            1 -> imageList[4] = R.drawable.whiteoval
            2 -> {
                imageList[4] = R.drawable.whiteoval
                imageList[5] = R.drawable.whiteoval
                }
            3 -> {
                imageList[4] = R.drawable.whiteoval
                imageList[5] = R.drawable.whiteoval
                imageList[6] = R.drawable.whiteoval
            }
            4 ->{
                imageList[4] = R.drawable.whiteoval
                imageList[5] = R.drawable.whiteoval
                imageList[6] = R.drawable.whiteoval
                imageList[7] = R.drawable.whiteoval
            }
        }

        when(wrong){
            1 -> imageList[7] = R.drawable.blackoval
            2 -> {
                imageList[7] = R.drawable.blackoval
                imageList[6] = R.drawable.blackoval
            }
            3 -> {
                imageList[7] = R.drawable.blackoval
                imageList[6] = R.drawable.blackoval
                imageList[5] = R.drawable.blackoval
            }
            4 ->{
                imageList[7] = R.drawable.blackoval
                imageList[6] = R.drawable.blackoval
                imageList[5] = R.drawable.blackoval
                imageList[4] = R.drawable.blackoval
            }
        }


    }

    private fun findColor() {


        var forsta = (0..5).random()
        var andra = (0..5).random()
        while (forsta == andra){
            andra = (0..5).random()
        }

        var tredje = (0..5).random()
        while (tredje == forsta || tredje == andra){
            tredje = (0..5).random()
        }

        var fjerde = (0..5).random()
        while (fjerde == forsta || fjerde == andra || fjerde == tredje ){
            fjerde = (0..5).random()
        }


        when(forsta){
            0 -> first = R.drawable.white
            1 -> first = R.drawable.red
            2 -> first = R.drawable.yellow
            3 -> first = R.drawable.blue
            4 -> first = R.drawable.black
            5 -> first = R.drawable.green
        }

        when(andra){
            0 -> second = R.drawable.white
            1 -> second = R.drawable.red
            2 -> second = R.drawable.yellow
            3 -> second = R.drawable.blue
            4 -> second = R.drawable.black
            5 -> second = R.drawable.green
        }

        when(tredje){
            0 -> third = R.drawable.white
            1 -> third = R.drawable.red
            2 -> third = R.drawable.yellow
            3 -> third = R.drawable.blue
            4 -> third = R.drawable.black
            5 -> third = R.drawable.green

        }

        when(fjerde){
            0 -> fourth = R.drawable.white
            1 -> fourth = R.drawable.red
            2 -> fourth = R.drawable.yellow
            3 -> fourth = R.drawable.blue
            4 -> fourth = R.drawable.black
            5 -> fourth = R.drawable.green
        }
        println("$first, $second, $third, $fourth")
    }

}