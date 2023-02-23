package co.talesbruno.consumeapifreetogame.presentation.ui.home.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.talesbruno.consumeapifreetogame.R

@Composable
fun DrawerHeader(modifier: Modifier = Modifier){
    Column(
        modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier
                .clip(CircleShape)
                .width(50.dp)
                .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
        )
        Text(text = "Games")
        Divider(color = Color.LightGray)
    }
}