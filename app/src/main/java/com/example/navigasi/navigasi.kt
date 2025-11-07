package com.example.navigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasi.view.BerandaScreen
import com.example.navigasi.view.FormulirPendaftaran
import com.example.navigasi.view.TampilanData

enum class Navigasi {
    Beranda,
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Beranda.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Beranda.name) {
                BerandaScreen(
                    onSubmitButtonClicked = {
                        navController.navigate(route = Navigasi.Formulir.name)
                    }
                )
            }
            composable(route = Navigasi.Formulir.name) {
                FormulirPendaftaran(
                    onSubmitButtonClicked = {
                        navController.navigate(Navigasi.Detail.name)
                    },
                    onBackButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilanData(
                    onBackToBerandaClick = { 
                        navController.popBackStack(Navigasi.Beranda.name, inclusive = false)
                     },
                    onBackToFormClick = { navController.popBackStack() }
                )
            }
        }
    }
}