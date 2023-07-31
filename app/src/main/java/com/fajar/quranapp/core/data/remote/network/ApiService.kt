package com.fajar.quranapp.core.data.remote.network

import com.fajar.quranapp.core.data.remote.response.ListSurahResponse
import com.fajar.quranapp.core.data.remote.response.SurahResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("surah")
    suspend fun getSurah(): ListSurahResponse

}