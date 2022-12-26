package com.ipca.budget.travelmobile

import android.content.res.AssetManager
import com.ipca.budget.travelmobile.entities.DataType
import com.ipca.budget.travelmobile.entities.Destiny
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import org.json.JSONObject

object Backend {
    fun fetchDestinies(scope: CoroutineScope, assets: AssetManager, dataType: DataType, destinies: ArrayList<Destiny>)  {
        scope.launch (Dispatchers.IO){
            var json: String? = null

            try {
                val inputStream: InputStream = assets.open("destinies.json")
                json = inputStream.bufferedReader().use { it.readText() }

                print(json)

                val jsonObj = JSONObject(json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1))


                val result: JSONArray? =  jsonObj
                    .getJSONObject(dataType.main?.typeStr)
                    .getJSONObject(dataType.secondary?.typeStr)
                    .getJSONArray(dataType.price?.typeStr)

                print(result)

                if (result != null) {
                    for(index in 0..result.length()) {
                        destinies.add(Destiny.fromJSON(result.getJSONObject(index)))
                    }
                }


            } catch (e: IOException) {

            }
        }
    }

    fun fetchHotels(scope: CoroutineScope) {
        //scope.launch (Dispatchers.IO){
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://apidojo-booking-v1.p.rapidapi.com/currency/get-exchange-rates?base_currency=USD&languagecode=en-us")
                .get()
                .addHeader("X-RapidAPI-Key", "fd9bda0a96mshd382468d93681e7p11744ajsn18f453e98759")
                .addHeader("X-RapidAPI-Host", "apidojo-booking-v1.p.rapidapi.com")
                .build()

            val response = client.newCall(request).execute()

            print(response)
        //}
    }
}