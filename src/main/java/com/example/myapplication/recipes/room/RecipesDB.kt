package com.example.myapplication.recipes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


private const val DATA_BASE_NAME="recipes_db"

@Database(entities = [Recetario::class], version = 1)


abstract class RecipesDB: RoomDatabase() {

    abstract fun getRecipesDao(): RecipesDao

    companion object{

        @Volatile

        private var INSTANCE: RecipesDB? = null

        fun getProductsDataBase(context: Context): RecipesDB {

            val tempInterface = INSTANCE
            if(tempInterface != null){
                return tempInterface
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    RecipesDB::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }

}