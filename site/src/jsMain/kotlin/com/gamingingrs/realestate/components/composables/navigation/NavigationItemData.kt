package com.gamingingrs.realestate.components.composables.navigation

import com.gamingingrs.realestate.utils.Image.CREATE_LISTING_IMG
import com.gamingingrs.realestate.utils.Image.HOME_IMG
import com.gamingingrs.realestate.utils.Image.LISTING_IMG
import com.gamingingrs.realestate.utils.Image.LOGOUT_IMG

data class NavigationItemData(
    val iconPath: String,
    val text: String,
    val onNavigate: () -> Unit
)

val adminNavigation = listOf(
    NavigationItemData(
        iconPath = HOME_IMG,
        text = "Home",
        onNavigate = {
            println("Clicked")
        }
    ),
    NavigationItemData(
        iconPath = LISTING_IMG,
        text = "My listings",
        onNavigate = {
            println("Clicked")
        }
    ),
    NavigationItemData(
        iconPath = CREATE_LISTING_IMG,
        text = "Create listing",
        onNavigate = {
            println("Clicked")
        }
    ),
    NavigationItemData(
        iconPath = LOGOUT_IMG,
        text = "Logout",
        onNavigate = {
            println("Clicked")
        }
    )
)