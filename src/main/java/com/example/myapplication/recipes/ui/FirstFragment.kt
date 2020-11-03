package com.example.myapplication.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.recipes.MyViewModel.Adapter
import com.example.myapplication.recipes.MyViewModel.PassRecipes
import com.example.myapplication.recipes.MyViewModel.ViewModelRecipes
import com.example.myapplication.recipes.room.Recetario
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(), PassRecipes {

    lateinit var mProductsViewModel: ViewModelRecipes
    lateinit var mAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProductsViewModel = ViewModelProvider(this).get(ViewModelRecipes::class.java)
        mAdapter = Adapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mProductsRecyclerView = recyclerView

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        mProductsViewModel.mAllRecipes.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListRecipes(it)
        })

        //view.findViewById<Button>(R.id.button_first).setOnClickListener {

        // }
    }

    override fun passRecipes(mRecetario: Recetario) {

        val mBundle = Bundle()
        mBundle.putString("name", mRecetario.img)
        mBundle.putString("image", mRecetario.nombreReceta)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)
    }
}
