package com.example.superhero.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
) {
}