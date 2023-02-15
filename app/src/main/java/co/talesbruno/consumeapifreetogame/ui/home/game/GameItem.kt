package co.talesbruno.consumeapifreetogame.ui.home.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import co.talesbruno.consumeapifreetogame.model.Game
import co.talesbruno.consumeapifreetogame.viewmodel.MainViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun GameItem(
    game: Game,
    onNavigateToDetailScreen: (Int) -> Unit,
) {
    Card(
        modifier = Modifier.padding(10.dp)
            .clickable { onNavigateToDetailScreen.invoke(game.id) }
    ) {
        Column() {
            Image(
                painter = rememberAsyncImagePainter(game.thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = game.title, fontWeight = FontWeight.ExtraBold)
                Text(text = game.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}