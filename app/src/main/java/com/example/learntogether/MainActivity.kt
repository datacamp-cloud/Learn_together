package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowInformation("JetPack Compose Tutorial", "first", "second")
                }
            }
        }
    }
}

@Composable
fun ImagePreview(modifier: Modifier = Modifier, title: String, firstPara: String, secondPara: String){
    val image = painterResource(R.drawable.bg_compose_background)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier.fillMaxWidth()
        )
        ShowInformation(
            title = title,
            firstPara = firstPara,
            secondPara = secondPara,
            modifier = modifier.background(Color.White)
        )
    }
}

@Composable
fun ShowInformation(title: String, firstPara: String, secondPara: String, modifier: Modifier = Modifier) {
    //titre
    Column {
        Text(
            text = title,
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp
        )

        //premier paragraphe
        Text(
            text = firstPara,
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )

        //deuxieme paragraphe
        Text(
            text = secondPara,
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}


object Resourses{
        const val TITLE = "JetPack Compose Tutorial"
        const val FIRST_PARA = "Jetpack Compose is a modern toolkit for building native Android UI." +
                "\nCompose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
        const val SECOND_PARA = "In this tutorial, you\'ll build a simple UI component with declarative functions." +
                "\nYou won\'t be editing any XML layouts or using the Layout Editor." +
                "\nInstead, you will call composable functions to define what elements you want, and the Compose compiler will do the rest." +
                "\nCompose is built around composable functions.\nThese functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, " +
                "rather than focusing on the process of the UI\'s construction (initializing an element, attaching it to a parent, etc.).\nTo create a composable function, just add the @Composable annotation to the function name."
}


@Preview(showBackground = true)
@Composable
fun LearnTogetherPreview() {
    val title = Resourses.TITLE
    val first = Resourses.FIRST_PARA
    val second = Resourses.SECOND_PARA

    LearnTogetherTheme {
        ImagePreview(
            title = title,
            firstPara = first,
            secondPara = second
        )
    }
}