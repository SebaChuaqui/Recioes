package com.example.myapplication.recipes.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.recipes.retrofit.Recipes
import com.example.myapplication.recipes.retrofit.RetrofitClient
import com.example.myapplication.recipes.room.Recetario
import com.example.myapplication.recipes.room.RecipesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRecipes(private val mRecipesDao: RecipesDao) {

    private val service = RetrofitClient.getRetrofitClient()

    val mRecipes = mRecipesDao.getAllRecipesFromDB()
    val mDataRecipesDBList = mutableListOf<Recipes>()

    fun getRecipesFromServer() {

        val mCall = service.fecthAllRecipes()
        mCall.enqueue(object : Callback<List<Recetario>> {
            override fun onResponse(
                call: Call<List<Recetario>>,
                response: Response<List<Recetario>>
            ) {
                Log.d("Prueba", response.body().toString())
                when (response.code()) {

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            Log.d("productos", it.toString())
                            mRecipesDao.insertAllRecipes(it)
                        }
                    }

                    in 300..399 -> Log.d("Error 300", response.errorBody().toString())
                    in 400..499 -> Log.d("Error 400", response.errorBody().toString())
                    in 500..599 -> Log.d("Error 500", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<Recetario>>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })

    }

    fun getOneById(id: String): LiveData<Recetario> {
        return mRecipesDao.getCodigoByID(id)
    }


}