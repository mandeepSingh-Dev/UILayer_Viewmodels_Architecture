package com.example.uilayer_viewmodels_architecture.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.example.uilayer_viewmodels_architecture.Model.MItem
import com.example.uilayer_viewmodels_architecture.MyViewModel
import com.example.uilayer_viewmodels_architecture.R
import com.example.uilayer_viewmodels_architecture.databinding.FragmentThreeBinding
import kotlinx.coroutines.launch


class FragmentThree : Fragment() {


    val myViewModel : MyViewModel by navGraphViewModels(R.id.nav_graph)
    val navArgs by navArgs<FragmentThreeArgs>()

    lateinit var binding : FragmentThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThreeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       //checking that viewmodel of Navgraph is same or not by verifying from any fragment viewmodel that uses NavGraphViewmodels.
        Log.d("rertegrgre",myViewModel.toString())

        binding.textview.append(navArgs.mItem?.value1.toString())


        lifecycleScope.launch{
            myViewModel.uiState.collect{

                binding.textview.append(it.toString())
                Log.d("dfdknfdf",it.toString())
            }
        }
    }

}