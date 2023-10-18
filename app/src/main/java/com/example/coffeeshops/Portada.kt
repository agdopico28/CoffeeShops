package com.example.coffeeshops

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeshops.ui.theme.FontTitle
import com.example.coffeeshops.ui.theme.Pink40
import com.example.coffeeshops.ui.theme.Pink80
import com.example.coffeeshops.ui.theme.Purple40
import com.example.coffeeshops.ui.theme.PurpleGrey40
import com.example.coffeeshops.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Portada( navController: NavHostController){
    var isMenuVisible by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
        }

        else -> {
            Scaffold (topBar = { TopAppBar(
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
                    Row (){
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
                    Row (){
                        DropdownMenu(
                            expanded = isMenuVisible,
                            onDismissRequest = {
                                isMenuVisible = false
                            },
                            modifier = Modifier.background(PurpleGrey80)
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
                                leadingIcon = {Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = null,
                                    tint = Color.Black
                                ) },
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
                                leadingIcon = {Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = null,
                                    tint = Color.Black
                                ) },
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Purple40)
            )}
                ) {
                Column (modifier= Modifier.padding(top = 60.dp)){
                    LazyColumn {
                        items(getCardCoffee()) { lazy ->
                            ItemsCoffe(cardCoffee = lazy, navController= navController)
                        }
                    }}
                }


        }
    }

}
data class CardCoffee(var name:String, var subbit:String, @DrawableRes var image :Int)

fun getCardCoffee(): List<CardCoffee> {
    return listOf(
        CardCoffee(
            "Antico Caffè Greco",
            "St.Italy,Rome",
            R.drawable.images
        ),
        CardCoffee(
            "Coffee Room",
            "St. Germany, Berlin",
            R.drawable.images1
        ),
        CardCoffee(
            "Coffee Ibiza",
            "St. Colon,Madrid",
            R.drawable.images2
        ),
        CardCoffee(
            "Pudding Coffee Shop",
            "St. Diagonal, Barcelona",
            R.drawable.images3
        ),
        CardCoffee(
            "L'Express",
            "St. Picadilly, London",
            R.drawable.images4
        ),
        CardCoffee(
            "Coffee Ibiza",
            "St.Àngel Guimerá, Valencia",
            R.drawable.images5
        ),
        CardCoffee(
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam",
            R.drawable.images6
        ),

    )
}
@Composable
fun ItemsCoffe(cardCoffee: CardCoffee, navController: NavHostController) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navController.navigate("Comentarios/${cardCoffee.name}") },
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = cardCoffee.image),
                contentDescription = "Coffee",
                modifier= Modifier
                    .fillMaxWidth()
                    .size(200.dp),
                contentScale = ContentScale.Crop
            )
            Row( modifier= Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = cardCoffee.name, fontFamily = FontTitle, fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.size(10.dp))

            RatingBar()
            Spacer(modifier = Modifier.size(10.dp))
            Row( modifier= Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)) {
                Text(text = cardCoffee.subbit)
            }
            Spacer(modifier = Modifier.size(10.dp))
            Divider()
            TextButton(onClick = { /*TODO*/ },
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color.Transparent, contentColor = Purple40
            )) {
                    Text(text = "RESERVE")

            }
        }
    }

}
@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    stars: Int = 5,
    starsColor: Color = Purple40
) {
    var starStates by remember { mutableStateOf(List(stars) { false }) }


    val onStarClick: (Int) -> Unit = { starIndex ->
        starStates = starStates.mapIndexed { index, _ ->
            index <= starIndex
        }
    }


    Row(modifier = modifier) {
        starStates.forEachIndexed { index, isFilled ->
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = if (isFilled) starsColor else PurpleGrey80,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { onStarClick(index) }
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){
    TopAppBar(title={ Text(text = "TopAppBar")})
}