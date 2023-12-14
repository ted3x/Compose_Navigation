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

class MainActivity : ComponentActivity() {
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
                    val currentEntry = navController.currentBackStackEntryAsState()
                    Column {
                        NavHost(navController = navController, startDestination = "introduction") {
                            composable("introduction") {
                                IntroductionSlide()
                            }
                            whatIsNavigation()
                            destinationsSlide()
                            navHostSlide()
                            navControllerSlide(navController)
                            argumentsSlide()
                            deeplinksSlide()
                            nestedNavigation()
                            bestPractices()
                            otherNavigationLibs()
                            composable(
                                route = "dummyslide?id={id}",
                                deepLinks = listOf(navDeepLink { uriPattern = "$uri/{id}" })
                            ) { backStackEntry ->
                                val id = backStackEntry.arguments?.getString("id")
                                DummySlide(id)
                            }
                        }
                        currentEntry.value?.let {
                            hierarchy[it.destination.route]?.let { hierarchy ->
                                SlideController(
                                    hierarchy = hierarchy,
                                    onNextClick = { nextDestination ->
                                        navController.navigate(
                                            nextDestination
                                        )
                                    },
                                    onPreviousClick = { navController.popBackStack() })
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Hierarchy(val previous: String?, val next: String?)

val hierarchy = mapOf(
    "introduction" to Hierarchy(null, "whatisnavigation"),
    "whatisnavigation" to Hierarchy("introduction", "destinations"),
    "destinations" to Hierarchy("whatisnavigation", "navhost"),
    "navhost" to Hierarchy("destinations", "navcontroller"),
    "navcontroller" to Hierarchy("navhost", "arguments"),
    "arguments" to Hierarchy("navcontroller", "deeplinks"),
    "deeplinks" to Hierarchy("arguments", "nested_navigation"),
    "nested_navigation" to Hierarchy("deeplinks", "best_practices"),
    "best_practices" to Hierarchy("nested_navigation", "other_navigation_libs"),
    "other_navigation_libs" to Hierarchy("best_practices", null)
)