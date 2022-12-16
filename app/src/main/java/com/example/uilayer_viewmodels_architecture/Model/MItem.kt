package com.example.uilayer_viewmodels_architecture.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MItem(var value1:String,var value2:Int,val value3:Double,var value4:Boolean) : Parcelable
