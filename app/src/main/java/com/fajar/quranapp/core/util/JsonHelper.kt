package com.fajar.quranapp.core.util

import android.content.Context
import com.fajar.quranapp.R
import com.fajar.quranapp.core.data.remote.response.SurahResponse
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(): String? {
        val jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.tourism).bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun loadData(): List<SurahResponse> {
        val list = ArrayList<SurahResponse>()
        val responseObject = JSONObject(parsingFileToString().toString())
        val listArray = responseObject.getJSONArray("places")
        for (i in 0 until listArray.length()) {
            val course = listArray.getJSONObject(i)

            val number = course.getInt("number")
            val englishName = course.getString("englishName")
            val numberOfAyahs = course.getInt("numberOfAyahs")
            val revelationType= course.getString("revelationType")
            val name = course.getString("name")
            val englishNameTranslation = course.getString("englishNameTranslation")


            val courseResponse = SurahResponse(
                number = number,
                name = name,
                englishName = englishName,
                numberOfAyahs = numberOfAyahs,
                revelationType = revelationType,
                englishNameTranslation = englishNameTranslation,
            )
            list.add(courseResponse)
        }
        return list
    }
}