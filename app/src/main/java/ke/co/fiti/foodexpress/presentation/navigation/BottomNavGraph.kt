package ke.co.fiti.foodexpress.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.fiti.foodexpress.R
import ke.co.fiti.foodexpress.presentation.screens.home.FavouritesScreen
import ke.co.fiti.foodexpress.presentation.screens.home.HomeScreen
import ke.co.fiti.foodexpress.presentation.screens.home.HomeViewModel
import ke.co.fiti.foodexpress.presentation.screens.home.OffersScreen
import ke.co.fiti.foodexpress.presentation.screens.home.SettingsScreen

@Composable
fun BottomNavGraph(homeViewmodel: HomeViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavScreens.HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomNavScreens.HomeScreen.route) {
                HomeScreen(homeViewmodel = homeViewmodel)
            }
            composable(route = BottomNavScreens.OffersScreen.route) {
                OffersScreen(navController)
            }
            composable(route = BottomNavScreens.SettingsScreen.route) {
                FavouritesScreen(navController)
            }
            composable(route = BottomNavScreens.SettingsScreen.route) {
                SettingsScreen(navController)
            }


        }
    }

}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.safeDrawingPadding()
    ) {

        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.home),
                tint = if (selectedIndex.value == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                    alpha = 0.2f
                ),
                contentDescription = "",
                modifier = Modifier.size(24.dp)

            )
        },
            label = {
                Text(
                    text = "Home",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = if (selectedIndex.value == 0) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                            alpha = 0.2f
                        ),
                        textAlign = TextAlign.Center,
                    )
                )
            },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                navHostController.navigate(BottomNavScreens.HomeScreen.route)
            })

        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.offers),
                tint = if (selectedIndex.value == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                    alpha = 0.2f
                ),
                contentDescription = "",
                modifier = Modifier.size(24.dp)

            )
        },
            label = {
                Text(
                    text = "Offers",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = if (selectedIndex.value == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                            alpha = 0.2f
                        ),
                        textAlign = TextAlign.Center,
                    )
                )
            },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
                navHostController.navigate(BottomNavScreens.OffersScreen.route)
            })

        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.favorite),
                tint = if (selectedIndex.value == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                    alpha = 0.2f
                ),
                contentDescription = "",
                modifier = Modifier.size(24.dp)

            )
        },
            label = {
                Text(
                    text = "Favourite",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = if (selectedIndex.value == 2) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                            alpha = 0.2f
                        ),
                        textAlign = TextAlign.Center,
                    )
                )
            },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
                navHostController.navigate(BottomNavScreens.FavouritesScreen.route)
            })
        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.profile),
                tint = if (selectedIndex.value == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                    alpha = 0.2f
                ),
                contentDescription = "",
                modifier = Modifier.size(24.dp)

            )
        },
            label = {
                Text(
                    text = "Settings",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = if (selectedIndex.value == 2) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                            alpha = 0.2f
                        ),
                        textAlign = TextAlign.Center,
                    )
                )
            },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
                navHostController.navigate(BottomNavScreens.SettingsScreen.route)
            })
    }
}

sealed class BottomNavScreens(val route: String) {
    object HomeScreen : BottomNavScreens(
        route = BottomNavRoute.Home.name
    )

    object OffersScreen : BottomNavScreens(
        route = BottomNavRoute.Offers.name
    )

    object FavouritesScreen : BottomNavScreens(
        route = BottomNavRoute.Favourites.name
    )

    object SettingsScreen : BottomNavScreens(
        route = BottomNavRoute.Settings.name
    )
}


enum class BottomNavRoute {
    Home, Offers, Favourites, Settings
}