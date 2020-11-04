package com.example.myapplication.recipes.retrofit.Pojo2


import com.google.gson.annotations.SerializedName

data class Recipes2(
    @SerializedName("recetario")
    val recetario: List<Recetario>
)