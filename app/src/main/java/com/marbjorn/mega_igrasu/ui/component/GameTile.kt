package com.marbjorn.mega_igrasu.ui.component

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marbjorn.mega_igrasu.R
import com.marbjorn.mega_igrasu.domain.Game
import com.marbjorn.mega_igrasu.ui.theme.DarkGreen


const val tileWidth = 200
@Composable
fun GameTile(
    modifier: Modifier,
    game: Game,
    addToCartButton: Boolean = false,
    removeFromCartButton: Boolean = false,
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .border(1.dp, Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.widthIn(10.dp, (tileWidth/1.5).dp),
            painter = painterResource(id = R.drawable.grand_theft_auto_san_andreas),
            contentDescription = "image"
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = game.title,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = game.price.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        if (addToCartButton) {
            AddToCartButton(modifier = Modifier) {
                onButtonClick()
            }
        }

        if (removeFromCartButton) {
            RemoveFromCartButton(modifier = Modifier) {
                onButtonClick()
            }
        }
    }
}

@Composable
fun AddToCartButton(modifier: Modifier, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = DarkGreen)
            .padding(12.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Icon(
            tint = Color.White,
            painter = painterResource(id = R.drawable.add_to_shopping_cart),
            contentDescription = "add to cart"
        )
    }
}

@Composable
fun RemoveFromCartButton(modifier: Modifier, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.Red)
            .padding(12.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Icon(
            tint = Color.White,
            painter = painterResource(id = R.drawable.outline_remove_shopping_cart_24),
            contentDescription = "add to cart"
        )
    }
}

@Composable
@Preview
private fun GameTilePreview() {
    val game = Game("111", "Grand Theft Auto: San Andreas", "description", 29.9)
    GameTile(modifier = Modifier, game = game, addToCartButton = true)
}