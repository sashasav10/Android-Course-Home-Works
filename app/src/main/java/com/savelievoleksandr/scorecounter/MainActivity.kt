package com.savelievoleksandr.scorecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View




class MainActivity : AppCompatActivity() {
    var scoreA=0
    var scoreB=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var scoreAText:TextView=findViewById(R.id.scoreATextView)
        var scoreBText:TextView=findViewById(R.id.scoreBTextView)
        var a1:Button=findViewById(R.id.add1ABtn)
        var a2:Button=findViewById(R.id.add2ABtn)
        var a3:Button=findViewById(R.id.add3ABtn)
        var b1:Button=findViewById(R.id.add1BBtn)
        var b2:Button=findViewById(R.id.add2BBtn)
        var b3:Button=findViewById(R.id.add3BBtn)
        var resetBtn:Button=findViewById(R.id.resetBtn)
        a1.setOnClickListener{
            scoreA += 1
            count(scoreA,scoreAText)
        }
        a2.setOnClickListener{
            scoreA += 2
            count(scoreA,scoreAText)
        }
        a3.setOnClickListener{
            scoreA += 3
            count(scoreA,scoreAText)
        }
        b1.setOnClickListener{
            scoreB += 1
            count(scoreB,scoreBText)
        }
        b2.setOnClickListener{
            scoreB += 2
            count(scoreB,scoreBText)
        }
        b3.setOnClickListener{
            scoreB += 3
            count(scoreB,scoreBText)
        }
        resetBtn.setOnClickListener{
            scoreA = 0
            scoreB = 0
            count(scoreA,scoreAText)
            count(scoreB,scoreBText)
        }
    }

    fun count(score:Int, textView: TextView)
    {
        textView.text = score.toString()
    }

}