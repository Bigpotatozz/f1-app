package com.oscar.f1app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.oscar.f1app.home.ui.HomeScreen
import com.oscar.f1app.home.ui.HomeViewModel
import com.oscar.f1app.ui.theme.F1AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {





            F1AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { NavBar() })
                { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding).background(color  = Color(0xFF393E46)), homeViewModel)


                }
            }
        }
    }
}


@Composable
fun NavBar(){
    //indice
    var selectedItem by rememberSaveable { mutableStateOf(0)};
    //Nombre de las secciones
    val items = listOf("Drivers", "Profile", "Settings");
    //iconos
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Person, Icons.Filled.Settings);
    //iconos cuando no estan seleccionados
    val unselectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Person, Icons.Filled.Settings);

    NavigationBar(modifier = Modifier,
        containerColor = NavigationBarDefaults.containerColor,
        contentColor = MaterialTheme.colorScheme.contentColorFor(NavigationBarDefaults.containerColor)
        ) {
        //recorre cada seccion sacando su indice y contenido
        items.forEachIndexed{index, item ->
            //Crea el item de navegacion
            NavigationBarItem(icon = {
                Icon( if(selectedItem == index) selectedIcons[index] else unselectedIcons[index]
                    ,contentDescription = item)},
                label = { Text(item)},
                selected = selectedItem == index,
                onClick = {selectedItem == index})
        }
    }


}
