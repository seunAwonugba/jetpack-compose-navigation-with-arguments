package com.example.jetpacknavigation

sealed class Screens(val route : String){
    object HomeScreen : Screens("home_screen")
    object DetailsScreen : Screens("details_screen")

    //pass data with arguments
    fun withArgs(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }

    }

}
