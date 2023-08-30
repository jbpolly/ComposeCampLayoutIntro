package com.mysticraccoon.composecamplayoutintro.core.navigation

import com.mysticraccoon.composecamplayoutintro.core.navigation.RouteKeys.MEDITATION_DETAILS_NAME_PARAM


object RouteKeys{
    const val MEDITATION_DETAILS_NAME_PARAM = "nameParam"
}

sealed class Route (val route: String){

    object Welcome: Route("Welcome")
    object Home: Route("Home")
    object MeditationDetails: Route("MeditationDetails/{$MEDITATION_DETAILS_NAME_PARAM}"){
        fun fromHomeToMeditationDetails(name: String) = "MeditationDetails/$name"
    }

    object Sounds: Route("Sounds")

    object Tracking: Route("Tracking")

}
