package com.example.toptabnaviagtion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toptabnaviagtion.screens.AccountScreen
import com.example.toptabnaviagtion.screens.EditScreen
import com.example.toptabnaviagtion.screens.HomeScreen

@Composable
fun NavigationHost(navController: NavHostController){

  NavHost(navController = navController, startDestination = ScreenDestination.HomeScreen){

      composable< ScreenDestination.HomeScreen> {
          HomeScreen()
      }
      composable< ScreenDestination.EditScreen> {
          EditScreen()
      }
      composable< ScreenDestination.AccountScreen> {
          AccountScreen()
      }
  }

}
