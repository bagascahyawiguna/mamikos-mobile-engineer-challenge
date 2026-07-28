package io.github.bagascahyawiguna.showcase.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.github.bagascahyawiguna.showcase.presentation.screen.DetailScreen
import io.github.bagascahyawiguna.showcase.presentation.screen.HomeScreen

object NavDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_SHOW_ID_ARG = "showId"
    const val DETAIL_ROUTE = "detail/{$DETAIL_SHOW_ID_ARG}"

    fun createDetailRoute(showId: Int): String = "detail/$showId"
}

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = NavDestinations.HOME_ROUTE) {
            HomeScreen(
                onShowClick = { showId ->
                    navController.navigate(NavDestinations.createDetailRoute(showId))
                }
            )
        }

        composable(
            route = NavDestinations.DETAIL_ROUTE,
            arguments = listOf(
                navArgument(NavDestinations.DETAIL_SHOW_ID_ARG) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val showId = backStackEntry.arguments?.getInt(NavDestinations.DETAIL_SHOW_ID_ARG) ?: 0
            DetailScreen(
                showId = showId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
