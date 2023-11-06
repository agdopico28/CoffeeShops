package com.example.coffeeshops

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.coffeeshops.ui.theme.FontTitle
import com.example.coffeeshops.ui.theme.Pink40
import com.example.coffeeshops.ui.theme.Pink80
import com.example.coffeeshops.ui.theme.Purple40
import com.example.coffeeshops.ui.theme.Purple80
import com.example.coffeeshops.ui.theme.PurpleGrey40
import com.example.coffeeshops.ui.theme.PurpleGrey80


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun COmentarios(navControllerName:String, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val listState = rememberLazyStaggeredGridState() 
    val nombreCafeteria = navBackStackEntry?.arguments?.getString("cafeteriaName") ?: ""  //pasa el nombre de la pantalla anterior
    val buttonVisible = remember { mutableStateOf(true) }

            Scaffold(topBar = {
                MyTopAppBar()
            }
            ) {
                Column (modifier= Modifier.padding(top = 15.dp) ){
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp),horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = nombreCafeteria, // la variable que tenemos arriba
                            fontFamily = FontTitle,
                            fontSize = 32.sp,
                            color = Color.Black,
                        )
                    }

                    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), state = listState){ //implementa los comentarios en dos columnas
                                                                                        // y le pasas tambien el estado de la lista para después poner un boton
                        items(getComentario().size) { coment ->
                            ItemsComentario(comentario = coment)
                        }
                    }

                    val scrollOffset = listState.firstVisibleItemScrollOffset //para que cuando scrolles se haga visible
                    if (scrollOffset > 0 && buttonVisible.value) { //si esta arriba del todo no se ensañara el boton
                        buttonVisible.value = false
                    } else if (scrollOffset == 0 && !buttonVisible.value) { //si esta bajado se mostrara el boto
                        buttonVisible.value = true
                    }
                }
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter) { //el boto nque aparece si scrolleas
                    if (!buttonVisible.value) {
                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .padding(16.dp)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(Purple80),
                        ) {
                            Text(text = "Add new comment")
                        }
                    }
                }
                }

            }



 //almacena todos los comentarios
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
fun ItemsComentario(comentario: Int) { //crea las cartas que llevan los comentarios
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
                Text(
                    text = coment[comentario], fontSize = 16.sp, //recorre la lista de los comentarios y  introduce el comentario que le has pasado a la funcion
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp))
            }


        }
    }

}
