package com.example.todolist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.navigation.TodoNavHost
import com.example.todolist.pages.HomePage
import com.example.todolist.pages.LoginPage
import com.example.todolist.pages.SingupPage
import com.example.todolist.ui.feature.list.ListScreen

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder ={
        composable("login"){
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup"){
            SingupPage(modifier, navController, authViewModel)
        }
        composable("home"){
            HomePage(modifier, navController, authViewModel)
        }
        composable("todolist"){
            TodoNavHost(
                navigateBackToHome = {
                    navController.popBackStack()
                }
            )
        }
    })
}