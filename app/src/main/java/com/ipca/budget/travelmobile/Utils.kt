package com.ipca.budget.travelmobile

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.reflect.KClass

object Utils {
    fun addClickEventToButtons(layout: ConstraintLayout, callback: () -> Unit) {
        for (i in 0 until layout.getChildCount()) {
            val view: View = layout.getChildAt(i)

            if (view is Button) {
                view.setOnClickListener{
                    callback()
                };
            }
        }
    }
}