package com.aalh.firebase

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aalh.firebase.presentation.initial.InitialScreen
import com.aalh.firebase.presentation.login.LoginScreen
import com.aalh.firebase.presentation.signup.SignUpScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("login") },
                navigateToSignUp = { navHostController.navigate("signup")}
            )
        }
        composable("login") {
            LoginScreen(auth)
        }
        composable("signup") {
            SignUpScreen(auth)
        }

    }
}