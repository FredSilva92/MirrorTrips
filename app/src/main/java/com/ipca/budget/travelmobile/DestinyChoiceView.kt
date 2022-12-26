package com.ipca.budget.travelmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class DestinyChoiceView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_choice_view)

        val containerButton = findViewById<ConstraintLayout>(R.id.container_button)

        Utils.addClickEventToButtons(containerButton) {
            val intent = Intent(this@DestinyChoiceView, VacationsPeriodChoice::class.java)
            startActivity(intent)
        }
    }
}