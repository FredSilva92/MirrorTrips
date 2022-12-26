package com.ipca.budget.travelmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class VacationsPeriodChoice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacations_period_choice)

        val containerButton = findViewById<ConstraintLayout>(R.id.container_button)

        Utils.addClickEventToButtons(containerButton) {
            val intent = Intent(this@VacationsPeriodChoice, EmailSendView::class.java)
            startActivity(intent)
        }
    }
}