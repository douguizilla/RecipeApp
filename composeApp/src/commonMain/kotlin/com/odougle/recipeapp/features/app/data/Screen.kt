package com.odougle.recipeapp.features.app.data

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import recipeapp.composeapp.generated.resources.Res
import recipeapp.composeapp.generated.resources.bookmark_selected
import recipeapp.composeapp.generated.resources.bookmark_unselected
import recipeapp.composeapp.generated.resources.detail
import recipeapp.composeapp.generated.resources.favorites
import recipeapp.composeapp.generated.resources.home
import recipeapp.composeapp.generated.resources.home_selected
import recipeapp.composeapp.generated.resources.home_unselected
import recipeapp.composeapp.generated.resources.profile
import recipeapp.composeapp.generated.resources.profile_selected
import recipeapp.composeapp.generated.resources.profile_unselected
import recipeapp.composeapp.generated.resources.search
import recipeapp.composeapp.generated.resources.tabs

sealed class Screen(
    val route: String,
    val resourceId: StringResource,
    val selectedIcon: DrawableResource? = null,
    val unselectedIcon: DrawableResource? = null
) {
    data object Search : Screen(route = "search", resourceId = Res.string.search)
    data object Tabs : Screen(route = "tabs", resourceId = Res.string.tabs)
    data object Detail : Screen(route = "detail", resourceId = Res.string.detail)

    data object Home : Screen("home",
        Res.string.home,
        selectedIcon = Res.drawable.home_selected,
        unselectedIcon = Res.drawable.home_unselected
    )

    data object Favorites : Screen("favorites",
        Res.string.favorites,
        selectedIcon = Res.drawable.bookmark_selected,
        unselectedIcon = Res.drawable.bookmark_unselected
    )

    data object Profile : Screen("profile",
        Res.string.profile,
        selectedIcon = Res.drawable.profile_selected,
        unselectedIcon = Res.drawable.profile_unselected
    )
}