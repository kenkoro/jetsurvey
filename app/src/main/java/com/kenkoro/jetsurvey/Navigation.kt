package com.kenkoro.jetsurvey

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kenkoro.jetsurvey.Destinations.SIGN_IN_ROUTE
import com.kenkoro.jetsurvey.Destinations.SIGN_UP_ROUTE
import com.kenkoro.jetsurvey.Destinations.SURVEY_RESULTS_ROUTE
import com.kenkoro.jetsurvey.Destinations.SURVEY_ROUTE
import com.kenkoro.jetsurvey.Destinations.WELCOME_ROUTE

object Destinations {
    const val WELCOME_ROUTE = "welcome"
    const val SIGN_UP_ROUTE = "signup/{email}"
    const val SIGN_IN_ROUTE = "signin/{email}"
    const val SURVEY_ROUTE = "survey"
    const val SURVEY_RESULTS_ROUTE = "surveyresults"
}

@Composable
fun JetSurveyNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = WELCOME_ROUTE
    ) {
        composable(WELCOME_ROUTE) {
            TODO("Implement the welcome route")
        }

        composable(SIGN_IN_ROUTE) {
            TODO("Implement the sign in route")
        }

        composable(SIGN_UP_ROUTE) {
            TODO("Implement the sign up route")
        }

        composable(SURVEY_ROUTE) {
            TODO("Implement the survey route")
        }

        composable(SURVEY_RESULTS_ROUTE) {
            TODO("Implement the survey results route")
        }
    }
}