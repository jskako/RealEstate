package com.gamingingrs.realestate.components.composables.navigation

data class NavigationItemData(
    val iconPath: String,
    val title: String,
    val onNavigate: () -> Unit
)
