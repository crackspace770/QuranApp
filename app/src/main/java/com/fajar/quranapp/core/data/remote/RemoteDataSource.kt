package com.fajar.quranapp.core.data.remote


import android.util.Log
import com.fajar.quranapp.core.data.remote.network.ApiResponse
import com.fajar.quranapp.core.data.remote.network.ApiService
import com.fajar.quranapp.core.data.remote.response.SurahResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    suspend fun getAllQuran(): Flow<ApiResponse<List<SurahResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getSurah()
                val dataArray = response.list
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.list))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

