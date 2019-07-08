package com.example.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    val TAG = "MAIN"

   // var button= Array<Button>(3) {Array<Button>(3)  }
    var player1points=0
    var player2points=0


    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var ActivePlayer=1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        backbtn.setOnClickListener {
            val intent=Intent(this,start::class.java)
            startActivity(intent)
        }
        attachlistner()
    }

     private fun attachlistner()
{
    btn1.setOnClickListener(this)
    btn2.setOnClickListener(this)
    btn3.setOnClickListener(this)
    btn4.setOnClickListener(this)
    btn5.setOnClickListener(this)
    btn6.setOnClickListener(this)
    btn7.setOnClickListener(this)
    btn8.setOnClickListener(this)
    btn9.setOnClickListener(this)
    rstbtn.setOnClickListener(this)

}

    override fun onClick(p0: View) {

        val p01=p0 as Button

        var cellID = 0

        when (p01.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
            R.id.rstbtn-> {
                cellID=10
               resetbutton()

            }



        }

            Game(cellID, p0)



    }

     fun resetbutton()
     {
         player1.clear()
         player2.clear()
         player1points=0
         player2points=0
         ActivePlayer=0

         btn1.text=""
         btn2.text=""
         btn3.text=""
         btn4.text=""
         btn5.text=""
         btn6.text=""
         btn7.text=""
         btn8.text=""
         btn9.text=""
         tv1.setText("Player 1 score is : ${player1points.toString()}")
         tv2.setText("Player 2 score is : ${player2points.toString()}")
         tv3.setText(" ")
         btn1.isEnabled=true
         btn2.isEnabled=true
         btn3.isEnabled=true
         btn4.isEnabled=true
         btn5.isEnabled=true
         btn6.isEnabled=true
         btn7.isEnabled=true
         btn8.isEnabled=true
         btn9.isEnabled=true
     }
    fun resetgame()
    {

        player1.clear()
        player2.clear()
        btn1.text=""
        btn2.text=""
        btn3.text=""
        btn4.text=""
        btn5.text=""
        btn6.text=""
        btn7.text=""
        btn8.text=""
        btn9.text=""
        btn1.isEnabled=true
        btn2.isEnabled=true
        btn3.isEnabled=true
        btn4.isEnabled=true
        btn5.isEnabled=true
        btn6.isEnabled=true
        btn7.isEnabled=true
        btn8.isEnabled=true
        btn9.isEnabled=true




    }
    fun upgraderesult()
    {
        if(player1points>player2points)
        {
            tv3.setText("PLAYER 1 IS WINNING")
        }
        else
            if(player1points<player2points)
            {
                tv3.setText("PLAYER 2 IS WINNING")
            }
        else{
                tv3.setText("DRAW")
            }
    }


    fun Game(cellID:Int,btnselected:Button)
    {


        if(ActivePlayer==1){
            btnselected.text="O"
            player1.add(cellID)
            ActivePlayer=2

        }else{
            if (ActivePlayer==2)

            btnselected.text="X"

            player2.add(cellID)
            ActivePlayer=1
        }
        if(cellID!=10) {
            btnselected.isEnabled = false

            checkforwin()
        }
    }
    fun checkforwin()
    {
        var winner=-1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }


        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }



        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if(winner==-1&&(player1.size+player2.size)==9)
        {
            resetgame()
        }


        if( winner != -1){

            if (winner==1){
                player1points++
                tv1.setText("Player 1 score is : ${player1points.toString()}")
                upgraderesult()
                resetgame()

            }else{

                player2points++
                tv2.setText("Player 2 score is : ${player2points.toString()}")
                upgraderesult()
                resetgame()

            }


        }


    }
}


