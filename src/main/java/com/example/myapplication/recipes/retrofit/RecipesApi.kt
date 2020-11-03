package com.example.myapplication.recipes.retrofit


import com.example.myapplication.recipes.room.Recetario
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RecipesApi {

    @GET("recetario")
    fun fecthAllRecipes(): Call<List<Recetario>>

    @GET("recetario")
    suspend fun fetchAllCoroutines(): Response<List<Recetario>>
}