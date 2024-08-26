package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.utils.isUserAuthenticated
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomeScreen() {
    isUserAuthenticated {
        HomeLayout()
    }
}

@Composable
fun HomeLayout() {

}