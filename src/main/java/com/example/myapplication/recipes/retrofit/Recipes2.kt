package com.example.myapplication.recipes.retrofit
import com.example.myapplication.recipes.room.Recetario
import com.google.gson.annotations.SerializedName

data class Recipes2(
    @SerializedName("recetario")
    val recetario: List<Recetario>
)