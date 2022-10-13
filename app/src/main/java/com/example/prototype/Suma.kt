package com.example.prototype

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Suma (
    val numero1:String,
    val numero2:String,
    val suma:String,

    ) : Parcelable