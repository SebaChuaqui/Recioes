package com.example.myapplication.recipes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.recipes.MyViewModel.ViewModelRecipes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    lateinit var mRecipesViewModel: ViewModelRecipes

    var recipesId = 0
    var recipesIng = ""
    var recipesPre = ""
    var recipesRec = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mRecipesViewModel = ViewModelProvider(this).get(ViewModelRecipes::class.java)
        arguments?.let {
            recipesId = it.getInt("id")
            recipesIng = it.getString("ingredientes").toString()
            recipesPre = it.getString("preparacion").toString()
            recipesRec = it.getString("recomendacion").toString()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ingredientes.text = recipesIng
        preparacion.text = recipesPre
        recomendacion.text = recipesRec

        view.findViewById<Button>(R.id.button).setOnClickListener {
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        fab.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(){


            val intent = Intent(Intent.ACTION_SEND)
            val to = "info@plaplix.cl"
            val addressees = arrayOf(to)
            val subject = "Asunto "
            val message = "Hola \nVi este super Heroe llamado  y quiero comprarlo llámame al _________"
            intent.putExtra(Intent.EXTRA_EMAIL, addressees)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Contactar Area de Ventas:"))
        }
    }
}