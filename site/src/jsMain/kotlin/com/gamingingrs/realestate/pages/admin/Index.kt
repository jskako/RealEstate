package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.utils.Routes.FORBIDDEN_ROUTE
import com.gamingingrs.realestate.utils.userAuthenticated
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Page
@Composable
fun HomeScreen() {

    val context = rememberPageContext()

    userAuthenticated(
        navigateToOnFail = {
            context.router.navigateTo(FORBIDDEN_ROUTE)
        },
        onSuccessContent = {
            HomeLayout()
        }
    )
}

@Composable
fun HomeLayout() {

}