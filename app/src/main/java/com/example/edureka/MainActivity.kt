package com.example.edureka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.edureka.navgraph.SetNavGraph
import com.example.edureka.ui.theme.EdurekaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()          // remove title bar
        installSplashScreen()
        setContent {
            EdurekaTheme {
               
                
                Box(
                    modifier= Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.dark_blue_grey)),
                    contentAlignment = Alignment.Center
                ) {

                   SetNavGraph()
                }
            }
        }
    }
}


