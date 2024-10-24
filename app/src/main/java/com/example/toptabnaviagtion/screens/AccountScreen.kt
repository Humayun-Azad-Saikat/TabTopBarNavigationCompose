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

@Composable
fun AccountScreen(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Account Screen",
                fontFamily = FontFamily.Serif,
                fontSize = 40.sp,
                color = Color.Yellow
            )
        }
    }

}

@Preview
@Composable
fun AccountPreview(){
    AccountScreen()
}