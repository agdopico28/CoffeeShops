package com.example.coffeeshops

import android.content.res.Configuration
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Portada( navController: NavHostController){

    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            /*Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Spacer(modifier = Modifier.size(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = "EmailImage",
                    Modifier.width(50.dp).height(50.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = stringResource(id = R.string.playJuegos),
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontTitle

                )

                Spacer(modifier = Modifier.size(50.dp))
                Row{
                    Button(onClick = {}, modifier = Modifier.width(200.dp).padding(15.dp,0.dp)) {
                        Text(text = "Play")
                    }
                    Button(onClick = { navController.navigate("NewPlayer") }, modifier = Modifier.width(200.dp).padding(15.dp, 0.dp)) {
                        Text(text = "New Play")
                    }
                }
                Row{
                    Button(onClick = { navController.navigate("Preferences")},modifier = Modifier.width(200.dp).padding(15.dp, 0.dp)) {
                        Text(text = "Preferences")
                    }
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp).padding(15.dp, 0.dp)) {
                        Text(text = "About")
                    }
                }
            }*/
        }

        else -> {
            LazyColumn {
                items(getCardCoffee()) { lazy ->
                    ItemsCoffe(cardCoffee = lazy)
                }
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
fun ItemsCoffe(cardCoffee: CardCoffee) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = cardCoffee.image),
                contentDescription = "Coffee",
                modifier=Modifier.fillMaxWidth().size(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = cardCoffee.name)
            Text(text = cardCoffee.subbit)
            Divider()
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Reserve")

            }
        }
    }

}
@Composable
fun RatingBar(modifier: Modifier = Modifier,
              rating: Int = 0,
              stars : Int = 5,
              starsColor: Color = Color.Red){
    val unifilledStars = (stars - Math.ceil(rating.toDouble())).toInt()

}
