package com.example.myapplication.recipes.MyViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.recipes.repository.RepositoryRecipes
import com.example.myapplication.recipes.room.Recetario
import com.example.myapplication.recipes.room.RecipesDB


class ViewModelRecipes(application: Application): AndroidViewModel(application) {

    private val mRepositoryRecipes: RepositoryRecipes
    val mAllRecipes: LiveData<List<Recetario>>

    init {
        val mRecipesDao = RecipesDB.getProductsDataBase(application).getRecipesDao()
        mRepositoryRecipes = RepositoryRecipes(mRecipesDao)
        mAllRecipes = mRepositoryRecipes.mRecipes
        mRepositoryRecipes.getRecipesFromServer()

    }

    fun getOneID(id: String): LiveData<Recetario> {
        return mRepositoryRecipes.getOneById(id)
    }

}