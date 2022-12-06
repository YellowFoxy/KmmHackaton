package ru.sber.hackathon.android

import androidx.navigation.NavController

/**
 * @author Malyshev Alexandr
 */
object NavigationObject {
    var navController: NavController? = null

    fun navigate(place: String) {
        navController?.navigate(place)
    }
}