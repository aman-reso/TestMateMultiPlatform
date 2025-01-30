package org.com.testmatemultiplatform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.com.testmatemultiplatform.auth.ui.EnterPersonalDetailUi
import org.com.testmatemultiplatform.auth.ui.LoginUi
import org.com.testmatemultiplatform.auth.ui.VerifyOtpUi
import org.com.testmatemultiplatform.core.theme.RubikTypography
import org.com.testmatemultiplatform.core.theme.whiteBgColor
import org.com.testmatemultiplatform.core.theme.whiteColor
import org.com.testmatemultiplatform.group.create.CreateGroupUi
import org.com.testmatemultiplatform.group.post.ui.GroupPostHistoryMainUi
import org.com.testmatemultiplatform.localstorage.DatabaseHelper
import org.com.testmatemultiplatform.supportedExams.SupportedExamUi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App(databaseHelper: DatabaseHelper?) {
    MaterialTheme(typography = RubikTypography()) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        KoinContext {
            Scaffold(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = whiteBgColor),
                bottomBar = {
                    if (currentRoute in getBottomNavigation().map { it.route }) {
                        NavigationBar(containerColor = whiteColor) {
                            getBottomNavigation().forEach { item ->
                                NavigationBarItem(icon = {
                                    Icon(
                                        item.icon!!,
                                        contentDescription = null
                                    )
                                },
                                    label = { Text(item.label!!) },
                                    selected = currentRoute == item.route,
                                    onClick = {
                                        if (currentRoute != item.route) {
                                            navController.navigate(item.route) {
                                                navController.graph.startDestinationRoute?.let {
                                                    popUpTo(it)
                                                    launchSingleTop = true
                                                }
                                            }
                                        }
                                    })
                            }
                        }
                    }
                }) { innerPadding ->
                AppCentralNavigation(
                    navController,
                    modifier = Modifier.padding(innerPadding).fillMaxWidth().fillMaxHeight()
                        .background(color = whiteBgColor).padding(horizontal = 16.dp)
                ,databaseHelper)
            }
        }
    }
}

@Composable
private fun AppCentralNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    databaseHelper: DatabaseHelper?,
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
//            LoginUi {
//                navController.navigate(Screen.VerifyOtp.route)
//            }
            GroupPostHistoryMainUi(modifier, databaseHelper)
        }
        composable(Screen.VerifyOtp.route) {
            VerifyOtpUi {
                navController.navigate(Screen.EnterUserDetail.route)
            }
        }
        composable(Screen.EnterUserDetail.route) {
            EnterPersonalDetailUi {
                navController.navigate(Screen.Home.route)
            }
        }
        composable(Screen.Home.route) {
            CreateGroupUi()
        }
        composable(Screen.Events.route) {
            SupportedExamUi(modifier)
        }
        composable(Screen.Feed.route) {
            GroupPostHistoryMainUi(modifier,databaseHelper)
        }
        composable(Screen.Profile.route) {
            LoginUi {
                navController.navigate(Screen.EnterUserDetail.route)
            }
        }

        composable(
            "screen4/{data}", arguments = listOf(navArgument("data") { type = NavType.StringType })
        ) { backStackEntry ->

        }
    }
}


sealed class Screen(val route: String, val label: String?, val icon: ImageVector?) {
    data object Home : Screen(route = "home", label = "Home", icon = Icons.Outlined.Home)
    data object Events : Screen("events", label = "Community", icon = Icons.Outlined.Edit)
    data object Feed : Screen("feed", label = "Ask", icon = Icons.Filled.Build)
    data object Profile : Screen("profile", label = "Profile", icon = Icons.Default.AccountCircle)
    data object Login : Screen(route = "login", label = "Login", icon = null)
    data object VerifyOtp : Screen(route = "verifyOtp", label = "Verify", icon = null)
    data object EnterUserDetail :
        Screen(route = "userDetailInput", label = "Enter you detail", icon = null)
}

fun getBottomNavigation(): List<Screen> {
    return listOf(Screen.Home, Screen.Events, Screen.Feed, Screen.Profile)
}