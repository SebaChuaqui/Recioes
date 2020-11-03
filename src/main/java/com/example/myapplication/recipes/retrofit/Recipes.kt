package com.example.myapplication.recipes.retrofit
import com.example.myapplication.recipes.Recetario
import com.google.gson.annotations.SerializedName

data class Recipes(
    @SerializedName("recetario")
    val recetario: List<Recetario>
)