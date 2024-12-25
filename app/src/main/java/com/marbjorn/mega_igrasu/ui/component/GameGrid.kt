package com.marbjorn.mega_igrasu.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marbjorn.mega_igrasu.domain.Game

@Composable
fun GameGrid(
    list: List<Game>,
    addToCartOption: Boolean = false,
    removeFromCartOption: Boolean = false,
    onButtonClick: () -> Unit
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(list) { game ->
            GameTile(
                modifier = Modifier.padding(12.dp),
                game = game,
                addToCartButton = addToCartOption,
                removeFromCartButton = removeFromCartOption
            ) {
                onButtonClick()
            }
        }
    }
}
@Composable
@Preview
private fun GameGridPreview() {
    val items = mutableListOf(
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99),
        Game("1", "A", "B", 1.99)
    )
    GameGrid(list = items, addToCartOption = true) { }
}