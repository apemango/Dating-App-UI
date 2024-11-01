package com.example.datingapp

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Search : Screens("search_screen")
    object Profile : Screens("profile_screen")
    object Chat : Screens("chat_screen")
    object ChatConversation : Screens("chat_conversation_screen")
    object Call : Screens("call_screen")

}