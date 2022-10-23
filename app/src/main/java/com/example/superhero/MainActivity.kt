package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.data.Hero
import com.example.superhero.data.HeroesRepository.heroes
import com.example.superhero.ui.theme.SuperheroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold(
        topBar = { AppTopBar() }
    ) {
        LazyColumn(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            items(heroes) {
                HeroItem(it)
            }
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
    ) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(74.dp)
                .fillMaxWidth(),

        ) {
            Column(

            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(8.dp)),

            )
        }
    }
}

@Composable
private fun AppTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroTheme {
        HeroItem(hero = heroes[0])
    }
}