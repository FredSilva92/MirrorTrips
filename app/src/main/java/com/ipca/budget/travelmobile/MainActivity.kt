package com.ipca.budget.travelmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.ipca.budget.travelmobile.Backend.fetchDestinies
import com.ipca.budget.travelmobile.Backend.fetchHotels
import com.ipca.budget.travelmobile.entities.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataType = DataType()
        var destinies = ArrayList<Destiny>();

        dataType.main = DataTypePrimary.BEACH
        dataType.secondary = DataTypeSecondary.CONFORT
        dataType.price = DataTypePrice.LOW_COST

        var startBtn = findViewById<Button>(R.id.startBtn)

        startBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, DestinySearch::class.java)
            startActivity(intent)
        }

        //fetchDestinies(lifecycleScope, assets, dataType, destinies)

        //fetchHotels(lifecycleScope)

        print(destinies);


    }
}