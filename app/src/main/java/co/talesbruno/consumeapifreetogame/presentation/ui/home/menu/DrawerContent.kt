package co.talesbruno.consumeapifreetogame.presentation.ui.home.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerContent(
    items: List<MenuItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn() {
        items(items) {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = it.icon,
                    contentDescription = it.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = it.title,
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}
