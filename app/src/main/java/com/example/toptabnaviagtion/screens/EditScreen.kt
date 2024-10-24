package com.example.toptabnaviagtion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import com.example.toptabnaviagtion.navigation.ScreenDestination

@Composable
fun EditScreen(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Green,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Edit Screen",
                fontFamily = FontFamily.Serif,
                fontSize = 40.sp,
                color = Color.Blue
            )
        }
    }

}

@Preview
@Composable
fun EditPreview(){
    val navController = rememberNavController()
    EditScreen()
}