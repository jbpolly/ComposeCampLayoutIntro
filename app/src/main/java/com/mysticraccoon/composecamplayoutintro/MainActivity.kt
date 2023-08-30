package com.mysticraccoon.composecamplayoutintro

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mysticraccoon.composecamplayoutintro.core.navigation.Route
import com.mysticraccoon.composecamplayoutintro.core.navigation.RouteKeys
import com.mysticraccoon.composecamplayoutintro.data.BottomNavItem
import com.mysticraccoon.composecamplayoutintro.ui.homeScreen.HomePage
import com.mysticraccoon.composecamplayoutintro.ui.meditationDetails.MeditationDetailsScreen
import com.mysticraccoon.composecamplayoutintro.ui.sounds.SoundsScreen
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationItemBackground
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationPink
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationWhite50
import com.mysticraccoon.composecamplayoutintro.ui.tracking.TrackingScreen
import com.mysticraccoon.composecamplayoutintro.ui.welcomePage.WelcomePage


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampLayoutIntroTheme {

                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = Route.Home.route,
                                    icon = Icons.Default.Home,
                                ),
                                BottomNavItem(
                                    name = "Sounds",
                                    route = Route.Sounds.route,
                                    icon = Icons.Filled.MusicNote,
                                ),
                                BottomNavItem(
                                    name = "Tracking",
                                    route = Route.Tracking.route,
                                    icon = Icons.Filled.TrackChanges,
                                ),
                            ),
                            navController = navController,
                            onItemClick = { item ->
                                navController.navigate(item.route)
                            },
                            modifier = Modifier,
                        )
                    }
                ) { contentPadding ->
                    LayoutIntoAppScreen(
                        navController = navController,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(contentPadding)
                    )
                }


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
                navArgument(RouteKeys.MEDITATION_DETAILS_NAME_PARAM) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString(RouteKeys.MEDITATION_DETAILS_NAME_PARAM)
            name?.let {
                MeditationDetailsScreen(textToPresent = it)
            } ?: run {
                Toast.makeText(LocalContext.current, "Name cannot be null", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        composable(
            route = Route.Sounds.route,
        ) {
            SoundsScreen()
        }

        composable(
            route = Route.Tracking.route
        ) {
            TrackingScreen()
        }


    }

}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    modifier: Modifier,
) {

    //val backStackEntry = navController.currentDestination?.route
    val backStackEntry = navController.currentBackStackEntryAsState()
   // if (navController.currentDestination?.route != Route.Welcome.route) {
    if (backStackEntry.value?.destination?.route != Route.Welcome.route) {
        NavigationBar(
            modifier = modifier,
            tonalElevation = 5.dp,
            containerColor = MeditationItemBackground
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        onItemClick(item)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MeditationPink,
                        unselectedIconColor = MeditationWhite50,
                    ),
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }
                )
            }
        }
    }

}


