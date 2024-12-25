package com.marbjorn.mega_igrasu.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marbjorn.mega_igrasu.R
import com.marbjorn.mega_igrasu.domain.Game
import com.marbjorn.mega_igrasu.ui.component.GameGrid
import com.marbjorn.mega_igrasu.ui.theme.Navy


@Composable
fun CatalogScreen(
    modifier: Modifier,
    list: List<Game>,
    currentPage: Int,
    onAddToCartClick: () -> Unit,
    onNextClick: () -> Unit,
    onPrevClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        GameGrid(list = list, addToCartOption = true) {
            onAddToCartClick()
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Navy),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(32.dp).clickable { onPrevClick() },
                painter = painterResource(id = R.drawable.prev),
                contentDescription = "prev"
            )
            Text(
                text = currentPage.toString(),
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
            Image(
                modifier = Modifier.size(32.dp).clickable { onNextClick() },
                painter = painterResource(id = R.drawable.next),
                contentDescription = "next"
            )
        }
    }
}

@Composable
@Preview
private fun CatalogScreenPreview() {
    val items = mutableListOf(
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99)
    )

    CatalogScreen(Modifier, list = items, 1, {}, {}, {})
}