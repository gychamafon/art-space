package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.art_space.ui.theme.ArtspaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtspaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PreviewFun()

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewFun() {
    var currentStep by remember {mutableIntStateOf(1)}
    val cats = remember {
        mutableStateOf(listOf(
            CatInfo(R.drawable.abissins_cat, R.string.abissin_cat_tittle, R.string.abissin_cat_description),
            CatInfo(R.drawable.british_cat, R.string.abissin_cat_tittle, R.string.abissin_cat_description),
            CatInfo(R.drawable.maine_coone_cat, R.string.abissin_cat_tittle, R.string.abissin_cat_description),
            CatInfo(R.drawable.oriental_cat, R.string.abissin_cat_tittle, R.string.abissin_cat_description),
            CatInfo(R.drawable.russian_blue_cat, R.string.abissin_cat_tittle, R.string.abissin_cat_description),
            CatInfo(R.drawable.thai_cat, R.string.abissin_cat_tittle, R.string.abissin_cat_description),
        ))
    }
    when (currentStep){
        1 ->
            ArtWorkView(catInfo = cats.value[0], onPreviousClick = {  currentStep = 1}, onNextClick = {currentStep = 2})
        2 ->
            ArtWorkView(catInfo = cats.value[1], onPreviousClick = { currentStep = 1 }, onNextClick = {currentStep = 3})
        3 ->
            ArtWorkView(catInfo = cats.value[2], onPreviousClick = { currentStep = 2 }, onNextClick = {currentStep = 4})
        4 ->
            ArtWorkView(catInfo = cats.value[3], onPreviousClick = { currentStep = 3 }, onNextClick = {currentStep = 5})
        5 ->
            ArtWorkView(catInfo = cats.value[4], onPreviousClick = { currentStep = 3}, onNextClick = {currentStep = 6})
        6 ->
            ArtWorkView(catInfo = cats.value[5], onPreviousClick = { currentStep = 4 }, onNextClick = {currentStep = 1})


    }

}

@Composable
fun ArtWorkView(
    catInfo: CatInfo,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,

    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = catInfo.imageResource),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(catInfo.title), style = MaterialTheme.typography.labelLarge,)
        Text(text = stringResource(id = catInfo.description), style = MaterialTheme.typography.labelLarge)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onPreviousClick) {
                Text(text = "Предыдущее")
            }
            Button(onClick = onNextClick) {
                Text(text = "Следующее")
            }
        }
    }
}


data class CatInfo(
    val imageResource: Int,
    val title: Int,
    val description: Int
)