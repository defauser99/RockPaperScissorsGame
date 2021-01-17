package binar.ch4.rockpaperscissors

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import binar.ch4.rockpaperscissors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var option1: String
    private lateinit var option2: String
    private var state1: Boolean = false
    private var state2: Boolean = false
    private lateinit var selected1: View
    private lateinit var selected2: View

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.result.visibility = View.GONE

        binding.playerRock.setOnClickListener {
            if (!state1) {
                selected1 = binding.playerRock
                refreshPlayerOption()
                state1 = true
                option1 = selected1.contentDescription.toString()
                binding.playerRock.background = getDrawable(R.drawable.bg_selected)
                computerGame()
                checkOption(option1, option2)
            } else {
                refreshPlayerOption()
                selected2.background = getDrawable(R.drawable.bg_unselected)
                Toast.makeText(this, "Rock unselected!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.playerPaper.setOnClickListener {
            if (!state1) {
                selected1 = binding.playerPaper
                refreshPlayerOption()
                state1 = true
                option1 = selected1.contentDescription.toString()
                binding.playerPaper.background = getDrawable(R.drawable.bg_selected)
                computerGame()
                checkOption(option1, option2)
            } else {
                refreshPlayerOption()
                selected2.background = getDrawable(R.drawable.bg_unselected)
                Toast.makeText(this, "Paper unselected!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.playerScissors.setOnClickListener {
            if (!state1) {
                selected1 = binding.playerScissors
                refreshPlayerOption()
                state1 = true
                option1 = selected1.contentDescription.toString()
                binding.playerScissors.background = getDrawable(R.drawable.bg_selected)
                computerGame()
                checkOption(option1, option2)
            } else {
                refreshPlayerOption()
                selected2.background = getDrawable(R.drawable.bg_unselected)
                Toast.makeText(this, "Scissors unselected!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.refreshBtn.setOnClickListener {
            resetState()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun refreshPlayerOption() {
        option1 = ""
        state1 = false
        selected1.background = getDrawable(R.drawable.bg_unselected)
        binding.result.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun computerGame() {
        when ((1..3).random()) {
            1 -> {
                selected2 = binding.comRock
                option2 = selected2.contentDescription.toString()
                selected2.background = getDrawable(R.drawable.bg_selected)
            }
            2 -> {
                selected2 = binding.comPaper
                option2 = selected2.contentDescription.toString()
                selected2.background = getDrawable(R.drawable.bg_selected)
            }
            3 -> {
                selected2 = binding.comScissors
                option2 = selected2.contentDescription.toString()
                selected2.background = getDrawable(R.drawable.bg_selected)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun checkOption(option1: String, option2: String) {
        binding.result.visibility = View.VISIBLE
        if (option1 == option2) {
            binding.result.background = getDrawable(R.drawable.bg_draw)
            binding.placeholder1.text = getString(R.string.game)
            binding.placeholder2.text = getString(R.string.draw)
        }
        when (option1) {
            "rock" -> {
                when (option2) {
                    "paper" -> {
                        binding.result.background = getDrawable(R.drawable.bg_lose)
                        binding.placeholder1.text = getString(R.string.player1)
                        binding.placeholder2.text = getString(R.string.lose)
                    }
                    "scissors" -> {
                        binding.result.background = getDrawable(R.drawable.bg_win)
                        binding.placeholder1.text = getString(R.string.player1)
                        binding.placeholder2.text = getString(R.string.win)
                    }
                }
            }
            "paper" -> {
                when (option2) {
                    "rock" -> {
                        binding.result.background = getDrawable(R.drawable.bg_win)
                        binding.placeholder1.text = getString(R.string.player1)
                        binding.placeholder2.text = getString(R.string.win)
                    }
                    "scissors" -> {
                        binding.result.background = getDrawable(R.drawable.bg_lose)
                        binding.placeholder1.text = getString(R.string.player1)
                        binding.placeholder2.text = getString(R.string.lose)
                    }
                }
            }
            "scissors" -> {
                when (option2) {
                    "paper" -> {
                        binding.result.background = getDrawable(R.drawable.bg_win)
                        binding.placeholder1.text = getString(R.string.player1)
                        binding.placeholder2.text = getString(R.string.win)
                    }
                    "rock" -> {
                        binding.result.background = getDrawable(R.drawable.bg_lose)
                        binding.placeholder1.text = getString(R.string.player1)
                        binding.placeholder2.text = getString(R.string.lose)
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun resetState() {
        option1 = ""
        option2 = ""
        state1 = false
        state2 = false
        selected1.background = getDrawable(R.drawable.bg_unselected)
        selected2.background = getDrawable(R.drawable.bg_unselected)
        binding.result.visibility = View.GONE
    }
}