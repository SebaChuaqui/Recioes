package com.example.myapplication.recipes.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRecipes(mRecipesList: List<Recetario>)

    @Query("SELECT * FROM recipes_table")
    fun getAllRecipesFromDB(): LiveData<List<Recetario>>

    @Query("SELECT * FROM recipes_table WHERE id=:id")
    fun getCodigoByID(id: String): LiveData<Recetario>

}