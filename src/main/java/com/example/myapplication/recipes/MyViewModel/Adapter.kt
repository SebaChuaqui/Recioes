package com.example.myapplication.recipes.MyViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.recipes.room.Recetario
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.android.synthetic.main.recipes.view.*


class Adapter(var mPassRecipes: PassRecipes ): RecyclerView.Adapter<Adapter.ViewHolderProducts>() {

    private var dataList = emptyList<Recetario>()

    fun updateListRecipes(mDataList: List<Recetario>){

        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class ViewHolderProducts(itemView: View): RecyclerView.ViewHolder(itemView){

        val mImg = itemView.imagerecipes
        val mName = itemView.namerecipes
        val mitemView = itemView.setOnClickListener{

            mPassRecipes.passRecipes(dataList[adapterPosition])
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProducts {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipes, parent, false)
        return ViewHolderProducts(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderProducts, position: Int) {

        val recipes1: Recetario = dataList[position]
        holder.mName.text = recipes1.nombreReceta
        Glide.with(holder.itemView.context)
            .load(recipes1.img)
            .into(holder.mImg)

    }

    override fun getItemCount() = dataList.size

}


interface PassRecipes{

    fun passRecipes(mRecetario: Recetario )
}