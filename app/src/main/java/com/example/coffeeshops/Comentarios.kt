package com.example.coffeeshops

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeshops.ui.theme.FontTitle
import com.example.coffeeshops.ui.theme.Pink40
import com.example.coffeeshops.ui.theme.Pink80




@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun COmentarios(navControllerName:String, navController: NavHostController) {
    var isMenuVisible by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
        }

        else -> {
            Scaffold(topBar = {
                TopAppBar(
                    title = {
                        Text(text = "CoffeeShops", color = Color.White, fontSize = 20.sp)
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    },
                    actions = {
                        Row() {
                            IconButton(
                                onClick = {
                                    isMenuVisible = true
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                        Row() {
                            DropdownMenu(
                                expanded = isMenuVisible,
                                onDismissRequest = {
                                    isMenuVisible = false
                                },
                                modifier = Modifier.background(Pink80)
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = "Compartir",
                                            color = Color.Black,
                                            fontSize = 16.sp
                                        )
                                    },
                                    onClick = { isMenuVisible = false },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Share,
                                            contentDescription = null,
                                            tint = Color.Black
                                        )
                                    },
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = "Album",
                                            color = Color.Black,
                                            fontSize = 16.sp
                                        )
                                    },
                                    onClick = { isMenuVisible = false },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Lock,
                                            contentDescription = null,
                                            tint = Color.Black
                                        )
                                    },
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Pink40)
                )
            }
            ) {
/*
                LazyColumn {
                    items(getComentario()) { lazy ->
                        ItemsComentario(comentario = lazy)
                    }
                }*/
                Column (modifier= Modifier.padding(top = 55.dp) ){
                    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)){

                        items(getComentario().size) { coment ->
                            ItemsComentario(comentario = coment)
                        }
                    }}
                }

            }

        }
    }


fun getComentario(): List<String> {
    return listOf(
        "Servicio algo flojo, aún así lo recomiendo",
        "Céntrica y acogedora. Volveremos seguro",
        "La ambientacion muy buena, pero en la planta de arriba un poco escasa.",
        "La comida estaba deliciosa y bastante bien de precio, mucha variedad de platos.\n" ,
        "El personal muy amable, nos permitieron ver todo el establecimiento.\n",
        "Muy bueno","Excelente. Destacable la extensa carta de cafés", "Buen ambiente y buen servicio. Lo recomiendo.",
        "En días festivos demasiado tiempo de espera. Los camareros/as no dan abasto. No lo recomiendo. No volveré",
        "Repetiremos. Gran selección de tartas y cafés.", "Todo lo que he probado en la cafetería está riquísimo, dulce o salado.\n",
        "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal.\n",
        "Puntos negativos: el servicio es muy lento y los precios son un poco elevados.",

        )
}
@Composable
fun ItemsComentario(comentario: Int) {
    val coment = getComentario()
    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {},
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = coment[comentario], fontSize = 16.sp)
            }


        }
    }

}