package com.example.uilayer_viewmodels_architecture.presentation.base

import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    
    fun showToast(msg:String){
        Toast.makeText(requireContext(), msg.toString(), Toast.LENGTH_SHORT).show()
    }


}