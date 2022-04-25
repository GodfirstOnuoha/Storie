package com.godfirst.storie

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.godfirst.storie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            nextButton.setOnClickListener {
                when ((infoImage.drawable as BitmapDrawable).bitmap) {
                    (ResourcesCompat.getDrawable(resources, R.drawable.baby, null) as BitmapDrawable).bitmap -> {
                        infoImage.setImageResource(R.drawable.child)
                        infoImage.animate().translationX(100.0f).duration = 1000
                        infoImage.animate().translationY(-200.0f).duration = 1000
                        infoText.text = getString(R.string.child)
                    }
                    (ResourcesCompat.getDrawable(resources, R.drawable.child, null) as BitmapDrawable).bitmap -> {
                        infoImage.setImageResource(R.drawable.youth)
                        infoImage.animate().translationX(200.0f).duration = 1000
                        infoImage.animate().translationY(-400.0f).duration = 1000
                        infoText.text = getString(R.string.youth)
                    }
                    (ResourcesCompat.getDrawable(resources, R.drawable.youth, null) as BitmapDrawable).bitmap -> {
                        infoImage.setImageResource(R.drawable.adult)
                        infoImage.animate().translationX(350.0f).duration = 1000
                        infoImage.animate().translationY(-200.0f).duration = 1000
                        infoText.text = getString(R.string.adult)
                    }
                    (ResourcesCompat.getDrawable(resources, R.drawable.adult, null) as BitmapDrawable).bitmap -> {
                        nextButton.visibility = View.INVISIBLE
                        infoImage.setImageResource(R.drawable.aged)
                        infoImage.animate().translationX(400.0f).duration = 1000
                        infoImage.animate().translationY(-50.0f).duration = 1000
                        infoText.text = getString(R.string.aged)
                    }
                    (ResourcesCompat.getDrawable(resources, R.drawable.aged, null) as BitmapDrawable).bitmap -> {
                        nextButton.visibility = View.INVISIBLE
                    }
                    else -> {
                        infoImage.setImageResource(R.drawable.aged)
                        nextButton.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }
}