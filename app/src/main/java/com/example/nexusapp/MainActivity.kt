package com.example.nexusapp

import AlumniDetailsScreen
import LoginScreen
import UserForm
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.nexusapp.Alumni.AlumniDashboard
import com.example.nexusapp.User.StudentDashboard
import com.example.nexusapp.ui.theme.NexusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexusAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlumniNavHost()
                }
            }
        }
    }
}

@Composable
fun AlumniNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController = navController) }
        composable("details") { UserForm(navController = navController) }
        // Placeholder for "add_alumni" and "search_alumni" if needed
        composable("add_alumni") { AlumniDetailsScreen(navController = navController) }
        composable("student_dashboard") { StudentDashboard() }
        composable("alumni_dashboard") { AlumniDashboard() }


    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("add_alumni") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Alumni")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Search Alumni")
        }
    }
}


@Composable
fun SearchAlumniScreen() {
    // Placeholder for Search Alumni Screen
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Search Alumni Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NexusAppTheme {
        AlumniNavHost()
    }
}


