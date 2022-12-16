package com.example.uilayer_viewmodels_architecture.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.example.uilayer_viewmodels_architecture.MyViewModel
import com.example.uilayer_viewmodels_architecture.R
import com.example.uilayer_viewmodels_architecture.databinding.FragmentTwoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentSix : Fragment() {

    lateinit var binding: FragmentTwoBinding
    val myViewmodel : MyViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_six, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            myViewmodel.uiState.collect{
                binding.textview.append("\n ${it.toString()}")
            }
        }
    }

}