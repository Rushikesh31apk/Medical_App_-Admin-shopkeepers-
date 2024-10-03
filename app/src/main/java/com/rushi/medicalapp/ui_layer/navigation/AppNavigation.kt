package com.rushi.medicalapp.ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rushi.medicalapp.ui_layer.screens.SignUpScreenUi
import com.rushi.medicalapp.ui_layer.screens.SingInScreenUi

@Composable
fun AppNavigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = LoginScreen) {
		composable<LoginScreen> {
			SingInScreenUi(navController = navController)
		}
		composable<SignUpScreen> {
			SignUpScreenUi(navController = navController)
		}
		composable<HomeScreen> {

		}
	}

}
