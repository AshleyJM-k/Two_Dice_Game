package com.cis.two_dice_pig

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivityOne : AppCompatActivity() {
    //declaring variables
    var playersTurn: String? = null
    var playerTurnTotal = 0
    var playerOneTotalScore = 0
    var playerTwoTotalScore = 0
    override fun onCreate(savedInstanceState: Bundle?) { //declaired top
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playersTurn = "Current Player: Player One"
        playerOneTotalScore = 0 //score will start at 0
        playerTwoTotalScore = 0 //score will start at 0
        playerTurnTotal = 0

        //buttons, images and views
        val roll = findViewById<View>(R.id.btnRollDie) as Button
        val hold = findViewById<View>(R.id.holdId) as Button
        val dieOne = findViewById<View>(R.id.ivDieOne) as ImageView
        val dieTwo = findViewById<View>(R.id.ivDieTwo) as ImageView
        val playerOneTotal = findViewById<View>(R.id.totalP1Tv) as TextView
        val playerTwoTotal = findViewById<View>(R.id.totalP2TV) as TextView
        val currentPlayer = findViewById<View>(R.id.currentTV) as TextView
        val turnTotal = findViewById<View>(R.id.turnTotalTV) as TextView
        val winner = findViewById<View>(R.id.gameWinnerTV) as TextView
        currentPlayer.text = playersTurn
        playerOneTotal.text = playerOneTotalScore.toString()
        playerTwoTotal.text = playerTwoTotalScore.toString()
        turnTotal.text = playerTurnTotal.toString()

//roll with images given from dice game using Java random
        roll.setOnClickListener {
            hold.isEnabled = true //lets user hit hold
            val ran = Random()
            val randomDice1 = ran.nextInt(7)
            val randomDice2 = ran.nextInt(7)
            when (randomDice1) {
                1 -> dieOne.setImageResource(R.drawable.dice1)
                2 -> dieOne.setImageResource(R.drawable.dice2)
                3 -> dieOne.setImageResource(R.drawable.dice3)
                4 -> dieOne.setImageResource(R.drawable.dice4)
                5 -> dieOne.setImageResource(R.drawable.dice5)
                6 -> dieOne.setImageResource(R.drawable.dice6)
            }
            when (randomDice2) {
                1 -> dieTwo.setImageResource(R.drawable.dice1)
                2 -> dieTwo.setImageResource(R.drawable.dice2)
                3 -> dieTwo.setImageResource(R.drawable.dice3)
                4 -> dieTwo.setImageResource(R.drawable.dice4)
                5 -> dieTwo.setImageResource(R.drawable.dice5)
                6 -> dieTwo.setImageResource(R.drawable.dice6)
            }
            if (playerOneTotalScore >= 50) {
                currentPlayer.text = "current Player: Player One"
                winner.text = "Player One Has Won The Game"
            } else if (playerTwoTotalScore >= 50) {
                currentPlayer.text = "Current Player: Player Two"
                winner.text = "Player Two Has Won The Game"
            }
            //terms given
            //if they roll a single one
            if (randomDice1 == 1 && randomDice2 != 1 || randomDice1 != 1 && randomDice2 == 1) {
                if (playersTurn == "Current Player: Player One") {
                    playersTurn = "Current Player: Player Two"
                    currentPlayer.text = playersTurn
                    playerTurnTotal = 0
                    turnTotal.text = playerTurnTotal.toString()
                } else {
                    playersTurn = "Current Player: Player One"
                    currentPlayer.text = playersTurn
                    playerTurnTotal = 0
                    turnTotal.text = playerTurnTotal.toString()
                }
                //if both are one
            }
            if (randomDice1 == 1 && randomDice2 == 1) //will turn players score to 0 and next players turn
            {
                if (playersTurn == "Player 1") {
                    playerTurnTotal = 0
                    turnTotal.text = playerTurnTotal.toString()
                    playerOneTotalScore = 0
                    playerOneTotal.text = playerOneTotalScore.toString()
                    playersTurn = "Current Player: Player 2"
                    currentPlayer.text = playersTurn
                } else {
                    playerTurnTotal = 0
                    turnTotal.text = playerTurnTotal.toString()
                    playerTwoTotalScore = 0
                    playerTwoTotal.text = playerTwoTotalScore.toString()
                    playersTurn = "Current Player: Player One"
                    currentPlayer.text = playersTurn
                }
            }
            if (randomDice1 == randomDice2) //two dice are the same
            {
                playerTurnTotal += randomDice1 + randomDice2
                turnTotal.text = playerTurnTotal.toString()
                hold.isEnabled = false
            } else {
                playerTurnTotal += randomDice1 + randomDice2
                turnTotal.text = playerTurnTotal.toString() //records turn total
            }
        }
        hold.setOnClickListener {
            if (playersTurn == "Current Player: Player One") {
                playerOneTotalScore += playerTurnTotal
                playerOneTotal.text =
                    playerOneTotalScore.toString() //sets to the int of the total score
                playersTurn = "Current Player: Player Two"
                currentPlayer.text = playersTurn
                playerTurnTotal = 0
            }
            if (playersTurn == "Current Player: Player Two") {
                playerTwoTotalScore += playerTurnTotal
                playerTwoTotal.text = playerTwoTotalScore.toString()
                playersTurn = "Current Player: Player One"
                currentPlayer.text = playersTurn
                playerTurnTotal = 0
            }
            turnTotal.text = playerTurnTotal.toString() //records overall turn total
        }
    }
}





