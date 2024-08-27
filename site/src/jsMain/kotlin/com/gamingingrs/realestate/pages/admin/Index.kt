package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gamingingrs.realestate.utils.Routes.FORBIDDEN_ROUTE
import com.gamingingrs.realestate.utils.userAuthenticated
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Page
@Composable
fun HomeScreen() {

    val context = rememberPageContext()
    var isUserAuthenticated by remember { mutableStateOf<Boolean?>(null) }

    userAuthenticated(
        isUserAuthenticated = {
            isUserAuthenticated = it
        }
    )

    when (isUserAuthenticated) {
        true -> {
            HomeLayout()
        }

        false -> {
            context.router.navigateTo(FORBIDDEN_ROUTE)
        }

        else -> Unit
    }
}

@Composable
private fun HomeLayout() {

}