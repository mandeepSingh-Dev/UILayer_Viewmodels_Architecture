package com.example.uilayer_viewmodels_architecture.presentation.base

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

class Baseapp : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.d("ifndf", "onCreate: ")

    }
}