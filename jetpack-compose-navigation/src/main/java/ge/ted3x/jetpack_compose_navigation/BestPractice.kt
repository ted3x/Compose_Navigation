package ge.ted3x.jetpack_compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import ge.ted3x.jetpack_compose_navigation.control.SlideController
import ge.ted3x.jetpack_compose_navigation.slides.DummySlide
import ge.ted3x.jetpack_compose_navigation.slides.IntroductionSlide
import ge.ted3x.jetpack_compose_navigation.slides.argumentsSlide
import ge.ted3x.jetpack_compose_navigation.slides.bestPractices
import ge.ted3x.jetpack_compose_navigation.slides.deeplinksSlide
import ge.ted3x.jetpack_compose_navigation.slides.destinationsSlide
import ge.ted3x.jetpack_compose_navigation.slides.navControllerSlide
import ge.ted3x.jetpack_compose_navigation.slides.navHostSlide
import ge.ted3x.jetpack_compose_navigation.slides.nestedNavigation
import ge.ted3x.jetpack_compose_navigation.slides.otherNavigationLibs
import ge.ted3x.jetpack_compose_navigation.slides.uri
import ge.ted3x.jetpack_compose_navigation.slides.whatIsNavigation
import ge.ted3x.jetpack_compose_navigation.ui.theme.AppTheme
import ge.ted3x.login.LOGIN_ROUTE
import ge.ted3x.login.loginGraph
import ge.ted3x.login.navigateToLogin
import ge.ted3x.registration.REGISTRATION_ROUTE
import ge.ted3x.registration.registrationGraph

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Column {
                        NavHost(navController = navController, startDestination = REGISTRATION_ROUTE) {
                            registrationGraph { navController.navigateToLogin("123") }
                            loginGraph()
                        }
                    }
                }
            }
        }
    }
}
