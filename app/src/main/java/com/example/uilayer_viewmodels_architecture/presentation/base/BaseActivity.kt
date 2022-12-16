package com.example.uilayer_viewmodels_architecture.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class BaseActivity : AppCompatActivity() {


    fun showToast(msg:String){
        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show()
    }

}