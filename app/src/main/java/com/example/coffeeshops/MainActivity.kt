package com.example.coffeeshops

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coffeeshops.ui.theme.CoffeeShopsTheme
import java.util.prefs.Preferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeShopsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //verticalArrangement = Arrangement.Center,
                    //horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val navController  = rememberNavController()
                    NavHost(navController = navController, startDestination = "Portada"){
                        composable("Portada") { Portada(navController = navController) }

                        //Este composable es necesario para mandar el titulo del caffe de una pantalla a otra
                        composable(
                            route = "Comentarios/{cafeteriaName}",
                            arguments = listOf(navArgument("cafeteriaName") { type = NavType.StringType })
                        ) { backStackEntry ->
                            COmentarios(backStackEntry.arguments?.getString("cafeteriaName") ?: "", navController)
                        }
                    }

                }
            }
        }
    }
}
