package com.example.toptabnaviagtion.navigation

import kotlinx.serialization.Serializable


sealed class ScreenDestination(){
    @Serializable
    object HomeScreen: ScreenDestination()
    @Serializable
    object EditScreen: ScreenDestination()
    @Serializable
    object AccountScreen: ScreenDestination()
}