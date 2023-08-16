package com.mysticraccoon.composecamplayoutintro

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mysticraccoon.composecamplayoutintro.core.navigation.Route
import com.mysticraccoon.composecamplayoutintro.core.navigation.RouteKeys
import com.mysticraccoon.composecamplayoutintro.ui.homeScreen.HomePage
import com.mysticraccoon.composecamplayoutintro.ui.meditationDetails.MeditationDetailsScreen
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme
import com.mysticraccoon.composecamplayoutintro.ui.welcomePage.WelcomePage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampLayoutIntroTheme {

                val navController = rememberNavController()

                LayoutIntoAppScreen(
                    navController = navController,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun LayoutIntoAppScreen(navController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navController,
        startDestination = Route.Welcome.route,
        modifier = modifier
    ) {

        composable(route = Route.Welcome.route) {
            WelcomePage(onStartClicked = {
                navController.navigate(Route.Home.route)
            })
        }

        composable(
            route = Route.Home.route,
        ) {
            HomePage(onNotificationClick = { text ->
                navController.navigate(Route.MeditationDetails.fromHomeToMeditationDetails(text))
            })
        }

        composable(
            route = Route.MeditationDetails.route,
            arguments = listOf(
                navArgument(RouteKeys.MEDITATION_DETAILS_NAME_PARAM){
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            val name = backStackEntry.arguments?.getString(RouteKeys.MEDITATION_DETAILS_NAME_PARAM)
            name?.let {
                MeditationDetailsScreen(textToPresent = it)
            } ?: run {
                Toast.makeText(LocalContext.current, "Name cannot be null", Toast.LENGTH_SHORT).show()
            }

        }
    }

}




