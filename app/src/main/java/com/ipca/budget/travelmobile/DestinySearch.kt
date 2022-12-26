package com.ipca.budget.travelmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.ipca.budget.travelmobile.Utils.addClickEventToButtons


class DestinySearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_search)

        val containerButton = findViewById<ConstraintLayout>(R.id.container_button)

        addClickEventToButtons(containerButton) {
            val intent = Intent(this@DestinySearch, VacationTypeView::class.java)
            startActivity(intent)
        }
    }

}