package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    /**
     * Hàm đổ xúc xắc và gán lại giá trị cho text view
     * @author DVHIEU (05/10/2023)
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val rollImage: ImageView = findViewById(R.id.diceImage)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        rollImage.setImageResource(drawableResource)

        rollImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Lớp xúc xắc
 * @author DVHIEU (05/10/2023)
 */
class Dice(private val numSides: Int) {
    /**
     * Hàm đổ xúc xắc
     * @return Giá trị xúc xắc
     * @author DVHIEU (05/10/2023)
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}