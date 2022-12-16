package com.example.uilayer_viewmodels_architecture.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.uilayer_viewmodels_architecture.Model.MItem
import com.example.uilayer_viewmodels_architecture.MyViewModel
import com.example.uilayer_viewmodels_architecture.R
import com.example.uilayer_viewmodels_architecture.databinding.FragmentOneBinding
import com.example.uilayer_viewmodels_architecture.databinding.FragmentTwoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentOne : Fragment() {

    lateinit var binding: FragmentOneBinding
    val myViewModel : MyViewModel by navGraphViewModels(R.id.nav_graph)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("kvndvcvd",myViewModel.toString())

        CoroutineScope(Dispatchers.Main).launch {
            myViewModel.uiState.collect{
                binding.textview.append("\n ${it.toString()}")
            }
        }

        binding.btn1.setOnClickListener {

            myViewModel._uiState.value = "fragmentTwo"

            val mitem = MItem(findNavController().currentDestination?.displayName.toString(),3,3.00,true)
            val navDirection = FragmentOneDirections.actionFragmentOneToFragmentTwo(mitem)

            findNavController().navigate(navDirection)
        }

        binding.btn2.setOnClickListener {
            myViewModel._uiState.value = "fragmentThree"

            val mitem = MItem(findNavController().currentDestination?.displayName.toString(),3,3.00,true)
            val navDirection = FragmentOneDirections.actionFragmentOneToFragmentThree(mitem)

            findNavController().navigate(navDirection)
        }






    }

}