package com.example.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity4 : AppCompatActivity(),View.OnClickListener {

    var i=0
    var diagcellID=0
    var player1points=0
    var player2points=0


    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var ActivePlayer=1
    var AI= ArrayList<Int>()

    val boardCells= Array(3) { arrayOfNulls<Button>(3) }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        boardCells[0][0] = btn1
        boardCells[0][1] = btn2
        boardCells[0][2] = btn3
        boardCells[1][0] = btn4
        boardCells[1][1] = btn5
        boardCells[1][2] = btn6
        boardCells[2][0] = btn7
        boardCells[2][1] = btn8
        boardCells[2][2] = btn9
        //boardCells[i][0]!!.text.toString()=="X"
        boardCells[0][0]?.setText(" ")
        boardCells[0][1]?.setText(" ")
        boardCells[0][2]?.setText(" ")
        boardCells[1][0]?.setText(" ")
        boardCells[1][1]?.setText(" ")
        boardCells[1][2]?.setText(" ")
        boardCells[2][0]?.setText(" ")
        boardCells[2][1]?.setText(" ")
        boardCells[2][2]?.setText(" ")



        backbtn.setOnClickListener {
            val intent= Intent(this,start::class.java)
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
        rstbtn.setOnClickListener{
            resetbutton()
        }

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




        }

        Game(cellID, p0)
        checkforwin()



    }

    fun resetbutton()
    {
        i=0
        AI.clear()
        ActivePlayer=1
        player1.clear()
        player2.clear()
        player1points=0
        player2points=0

        btn1.text=""
        btn2.text=""
        btn3.text=""
        btn4.text=""
        btn5.text=""
        btn6.text=""
        btn7.text=""
        btn8.text=""
        btn9.text=""
        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true
        tv1.setText("Your score is : ${player1points.toString()}")
        tv2.setText("Computer score is : ${player2points.toString()}")
        tv3.setText(" ")
    }
    fun resetgame()
    {
        i=0
        AI.clear()
        ActivePlayer=1

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
        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true




    }
    fun upgraderesult()
    {
        if(player1points>player2points)
        {
            tv3.setText("YOU ARE WINNING")
        }
        else
            if(player1points<player2points)
            {
                tv3.setText("COMPUTER IS WINNING")
            }
            else{
                tv3.setText("DRAW")
            }
    }


    fun Game(cellID:Int,btnselected: Button)
    {


        if(ActivePlayer==1){
            i++
            btnselected.text="O"
            player1.add(cellID)
            ActivePlayer=2
            AI.clear()

            if(i<=7) {

                computerAIEasy()
            }

        }
        btnselected.isEnabled=false


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
                tv1.setText("Your score is : ${player1points.toString()}")
                upgraderesult()
                resetgame()

            }else{

                player2points++
                tv2.setText("Computer score is : ${player2points.toString()}")
                upgraderesult()
                resetgame()

            }


        }


    }

    fun computerAIEasy() {
        if (winRowsAI() || winColsAI() || winDiagAI()) {

            var cellID:Int=0
            if(AI[0]==0&&AI[1]==0)
                cellID=1
            if(AI[0]==0&&AI[1]==1)
                cellID=2
            if(AI[0]==0&&AI[1]==2)
                cellID=3
            if(AI[0]==1&&AI[1]==0)
                cellID=4
            if(AI[0]==1&&AI[1]==1)
                cellID=5
            if(AI[0]==1&&AI[1]==2)
                cellID=6
            if(AI[0]==2&&AI[1]==0)
                cellID=7
            if(AI[0]==2&&AI[1]==1)
                cellID=8
            if(AI[0]==2&&AI[1]==2)
                cellID=9

            var buSelect: Button?
            when (cellID) {
                1 -> buSelect = btn1
                2 -> buSelect = btn2
                3 -> buSelect = btn3
                4 -> buSelect = btn4
                5 -> buSelect = btn5
                6 -> buSelect = btn6
                7 -> buSelect = btn7
                8 -> buSelect = btn8
                9 -> buSelect = btn9
                else->{
                    buSelect=btn1
                }
            }
            i++

            buSelect.text="X"
            buSelect.isEnabled=false

            player2.add(cellID)
            ActivePlayer=1
            AI.clear()
            attachlistner()






        }else
       if(blockRowsAI()||blockColsAI()||blockDiagAI()){



            var buSelect: Button?
            when (diagcellID) {
                1 -> buSelect = btn1
                2 -> buSelect = btn2
                3 -> buSelect = btn3
                4 -> buSelect = btn4
                5 -> buSelect = btn5
                6 -> buSelect = btn6
                7 -> buSelect = btn7
                8 -> buSelect = btn8
                9 -> buSelect = btn9
                else->{
                    buSelect=btn1
                }
            }
            i++

            buSelect.text="X"
            buSelect.isEnabled=false

            player2.add(diagcellID)
            ActivePlayer=1
            AI.clear()
            attachlistner()
        }
        else{

            AutoPlay()
        }
    }
    fun winRowsAI(): Boolean {

        for (i in 0..2) {
            if ((boardCells[i][0]!!.text.toString()=="X")&&(boardCells[i][1]!!.text.toString()=="X")&&(boardCells[i][2]!!.text.toString()=="")) {
                AI.add(0,i)
                AI.add(1,2)


                return true
            } else if((boardCells[i][1]!!.text.toString()=="X")&&(boardCells[i][2]!!.text.toString()=="X")&&(boardCells[i][0]!!.text.toString()==""))  {
                AI.add(0,i)
                AI.add(1,0)
                return true
            } else if((boardCells[i][0]!!.text.toString()=="X")&&(boardCells[i][2]!!.text.toString()=="X")&&(boardCells[i][1]!!.text.toString()==""))  {
                AI.add(0,i)
                AI.add(1,1)
                return true
            }
        }
        return false
    }
    fun winDiagAI(): Boolean {


        if ((boardCells[0][0]!!.text.toString()=="X")&&(boardCells[1][1]!!.text.toString()=="X")&&(boardCells[2][2]!!.text.toString()=="")) {
            AI.add(0,2)
            AI.add(1,2)


            return true
        } else if((boardCells[0][0]!!.text.toString()=="X")&&(boardCells[2][2]!!.text.toString()=="X")&&(boardCells[1][1]!!.text.toString()==""))  {
            AI.add(0,1)
            AI.add(1,1)
            return true
        } else if((boardCells[1][1]!!.text.toString()=="X")&&(boardCells[2][2]!!.text.toString()=="X")&&(boardCells[0][0]!!.text.toString()==""))  {
            AI.add(0,0)
            AI.add(1,0)
            return true
        }

        if ((boardCells[0][2]!!.text.toString()=="X")&&(boardCells[1][1]!!.text.toString()=="X")&&(boardCells[2][0]!!.text.toString()=="")) {
            AI.add(0,2)
            AI.add(1,0)


            return true
        } else if((boardCells[0][2]!!.text.toString()=="X")&&(boardCells[2][0]!!.text.toString()=="X")&&(boardCells[1][1]!!.text.toString()==""))  {
            AI.add(0,1)
            AI.add(1,1)
            return true
        } else if((boardCells[1][1]!!.text.toString()=="X")&&(boardCells[2][0]!!.text.toString()=="X")&&(boardCells[0][2]!!.text.toString()==""))  {
            AI.add(0,0)
            AI.add(1,2)
            return true
        }

        return false
    }
    fun winColsAI(): Boolean {

        for (i in 0..2) {
            if ((boardCells[0][i]!!.text.toString()=="X")&&(boardCells[1][i]!!.text.toString()=="X")&&(boardCells[2][i]!!.text.toString()=="")) {
                AI.add(0,2)
                AI.add(1,i)
                return true
            } else if((boardCells[1][i]!!.text.toString()=="X")&&(boardCells[2][i]!!.text.toString()=="X")&&(boardCells[0][i]!!.text.toString()==""))  {
                AI.add(0,0)
                AI.add(1,i)
                return true
            } else if((boardCells[0][i]!!.text.toString()=="X")&&(boardCells[2][i]!!.text.toString()=="X")&&(boardCells[1][i]!!.text.toString()==""))  {
                AI.add(0,1)
                AI.add(1,i)
                return true
            }
        }
        return false
    }
    fun blockRowsAI(): Boolean {

        if(player1.contains(1) && player1.contains(2) && (boardCells[0][2]!!.text.toString()=="")){
            diagcellID=3
            return true
        }
        else
        if(player1.contains(1) && player1.contains(3) && (boardCells[0][1]!!.text.toString()=="")){
           diagcellID=2
            return true
        }
        else
        if(player1.contains(2) && player1.contains(3) && (boardCells[0][0]!!.text.toString()=="")){
            diagcellID=1
            return true
        }
        else
        if(player1.contains(4) && player1.contains(5) && (boardCells[1][2]!!.text.toString()=="")){
            diagcellID=6
            return true
        }
        else
        if(player1.contains(4) && player1.contains(6) && (boardCells[1][1]!!.text.toString()=="")){
            diagcellID=5
            return true
        }
        else
        if(player1.contains(5) && player1.contains(6) && (boardCells[1][0]!!.text.toString()=="")){
            diagcellID=4
            return true
        }
        else

        if(player1.contains(7) && player1.contains(8) && (boardCells[2][2]!!.text.toString()=="")){
            diagcellID=9
            return true
        }
        else
        if(player1.contains(7) && player1.contains(9) && (boardCells[2][1]!!.text.toString()=="")){
            diagcellID=8
            return true
        }
        else
        if(player1.contains(8) && player1.contains(9) && (boardCells[2][0]!!.text.toString()=="")){
            diagcellID=7
            return true
        }

         return false
    }
    fun blockColsAI(): Boolean {

        if(player1.contains(1) && player1.contains(4) && (boardCells[2][0]!!.text.toString()=="")){
            diagcellID=7
            return true
        }
        else
            if(player1.contains(1) && player1.contains(7) && (boardCells[1][0]!!.text.toString()=="")){
                diagcellID=4
                return true
            }
            else
                if(player1.contains(4) && player1.contains(7) && (boardCells[0][0]!!.text.toString()=="")){
                    diagcellID=1
                    return true
                }
                else
                    if(player1.contains(2) && player1.contains(5) && (boardCells[2][1]!!.text.toString()=="")){
                        diagcellID=8
                        return true
                    }
                    else
                        if(player1.contains(2) && player1.contains(8) && (boardCells[1][1]!!.text.toString()=="")){
                            diagcellID=5
                            return true
                        }
                        else
                            if(player1.contains(5) && player1.contains(8) && (boardCells[0][1]!!.text.toString()=="")){
                                diagcellID=2
                                return true
                            }
                            else

                                if(player1.contains(3) && player1.contains(6) && (boardCells[2][2]!!.text.toString()=="")){
                                    diagcellID=9
                                    return true
                                }
                                else
                                    if(player1.contains(3) && player1.contains(9) && (boardCells[1][2]!!.text.toString()=="")){
                                        diagcellID=6
                                        return true
                                    }
                                    else
                                        if(player1.contains(6) && player1.contains(9) && (boardCells[0][2]!!.text.toString()=="")){
                                            diagcellID=3
                                            return true
                                        }

        return false
    }


    fun blockDiagAI(): Boolean {

        if(player1.contains(1) && player1.contains(5) && (boardCells[2][2]!!.text.toString()=="")){
            diagcellID=9
            return true
        }
        else
            if(player1.contains(1) && player1.contains(9) && (boardCells[1][1]!!.text.toString()=="")){
                diagcellID=5
                return true
            }
            else
                if(player1.contains(5) && player1.contains(9) && (boardCells[0][0]!!.text.toString()=="")){
                    diagcellID=1
                    return true
                }
                else
                    if(player1.contains(3) && player1.contains(5) && (boardCells[2][0]!!.text.toString()=="")){
                        diagcellID=7
                        return true
                    }
                    else
                        if(player1.contains(3) && player1.contains(7) && (boardCells[1][1]!!.text.toString()=="")){
                            diagcellID=5
                            return true
                        }
                        else
                            if(player1.contains(5) && player1.contains(7) && (boardCells[0][2]!!.text.toString()=="")){
                                diagcellID=3
                                return true
                            }


        return false
    }



    fun AutoPlay(){




        var emptyCells= ArrayList<Int>()
        for ( cellID in 1..9){

            if(!( player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }



        val r= Random(System.currentTimeMillis())
        val cellID:Int

        if(emptyCells.size==1) {
            cellID = emptyCells[0]

        }else {
            val randIndex = r.nextInt(0,emptyCells.size)

            cellID = emptyCells[randIndex]

        }







        var buSelect: Button?
        when (cellID) {
            1 -> buSelect = btn1
            2 -> buSelect = btn2
            3 -> buSelect = btn3
            4 -> buSelect = btn4
            5 -> buSelect = btn5
            6 -> buSelect = btn6
            7 -> buSelect = btn7
            8 -> buSelect = btn8
            9 -> buSelect = btn9
            else->{
                buSelect=btn1
            }
        }
        i++

        buSelect.text="X"
        buSelect.isEnabled=false
        player2.add(cellID)
        ActivePlayer=1
        AI.clear()
        attachlistner()


    }
}


