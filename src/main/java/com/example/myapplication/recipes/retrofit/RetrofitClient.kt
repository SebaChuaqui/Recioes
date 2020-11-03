package com.example.myapplication.recipes.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    companion object{

        private const val URL_BASE = "http://my-json-server.typicode.com/SebaChuaqui/Recetario/"

        fun getRetrofitClient(): RecipesApi {

            val mRetorfit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetorfit.create(RecipesApi::class.java)
        }
    }
}