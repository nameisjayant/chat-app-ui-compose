package com.nameisjayant.chatappui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.chatappui.screens.ChatScreen
import com.nameisjayant.chatappui.screens.HomeScreen
import com.nameisjayant.chatappui.screens.StartScreen

@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = START_SCREEN){
        composable(START_SCREEN){
            StartScreen(navHostController)
        }
        composable(HOME_SCREEN){
            HomeScreen(navHostController)
        }
        composable(CHAT_SCREEN){
            ChatScreen()
        }
    }

}

const val START_SCREEN  = "Start screen"
const val HOME_SCREEN = "Home screen"
const val CHAT_SCREEN = "Char screen"