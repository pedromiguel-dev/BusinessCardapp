package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}
@Composable
fun BusinessCardInformation(
    modifier: Modifier = Modifier
){
    val image: Painter = painterResource(id = R.drawable.eu_mesmo)
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = image, contentDescription = null)
        Text(text = "Pedro Miguel",
            fontSize = 50.sp,
            color = Color.White,
            fontWeight = FontWeight.Light
        )
        Text(text = "Mobile and web developer extraordinaire", color = Color(0xFF3ddc84),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 10.dp))
    }
}
@Composable
fun BusinessCardContactLine(
    icon: ImageVector = Icons.Rounded.Phone,
    contentDescriptionIcon: String,
    text: String
){
    Spacer(Modifier.fillMaxWidth().height(1.dp).border(1.dp, Color.White))
    Row(Modifier
        .padding(
            horizontal = 20.dp,
            vertical = 9.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ){
        Icon(icon, contentDescription = contentDescriptionIcon, tint = Color(0xFF3ddc84))
        Text(
            modifier = Modifier.padding(start = 18.dp),
            text = text,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
@Composable
fun BusinessCardContacts(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.Transparent)
    ) {
        BusinessCardContactLine(
            icon = Icons.Rounded.Phone,
            contentDescriptionIcon = "Telefone",
            text = "+55 (85) 99211-6661",
        )
        BusinessCardContactLine(
            icon = Icons.Rounded.Share,
            contentDescriptionIcon = "Linkedin",
            text = "pedro-miguel-276525207/",
        )
        BusinessCardContactLine(
            icon = Icons.Rounded.Email,
            contentDescriptionIcon = "Email",
            text = "pedro.miguel.e.idk.s@gmail.com",
        )
    }
}

@Composable
fun BusinessCardApp(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF073042))
    ) {
        BusinessCardInformation(Modifier.weight(3f))
        BusinessCardContacts(Modifier.weight(1f))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}