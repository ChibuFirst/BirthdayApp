package com.chibufirst.birthdayapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout: ConstraintLayout = findViewById(R.id.main_layout)
        val itemsLayout: LinearLayout = findViewById(R.id.items_layout)
        val profileImage: ImageView = findViewById(R.id.profile_image)
        val toggleButton: Button = findViewById(R.id.toggle_button)

        toggleButton.setOnClickListener {
            TransitionManager.beginDelayedTransition(itemsLayout, AutoTransition())
            if (toggleButton.text.toString() == getString(R.string.view_image)) {
                toggleButton.text = getString(R.string.hide_image)
                profileImage.visibility = View.VISIBLE
                mainLayout.setBackgroundColor(resources.getColor(R.color.light_purple_700, theme))
            } else {
                toggleButton.text = getString(R.string.view_image)
                profileImage.visibility = View.GONE
                mainLayout.setBackgroundColor(resources.getColor(R.color.white, theme))
            }
        }
    }
}