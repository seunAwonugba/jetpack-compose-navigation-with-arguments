package com.example.jetpacknavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(route=  Screens.HomeScreen.route) {
            Home(navController = navController)

        }
        composable(
            Screens.DetailsScreen.route + "/{passedName}",
            arguments = listOf(navArgument("passedName"){
                type = NavType.StringType
                nullable = true
                defaultValue = "Kindly input your user name"
            })
        ) {
            Details(it.arguments?.getString("passedName"))

        }
    }
}

@Composable
fun Home(navController: NavController){
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ){
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate(Screens.DetailsScreen.withArgs(text))},
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Details")
        }
    }
}

@Composable
fun Details(name : String?){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Hello $name")

    }
}