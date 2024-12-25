package com.marbjorn.mega_igrasu.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.marbjorn.mega_igrasu.R
import com.marbjorn.mega_igrasu.domain.Game
import com.marbjorn.mega_igrasu.ui.component.MenuItem
import com.marbjorn.mega_igrasu.ui.component.TopBar
import com.marbjorn.mega_igrasu.ui.theme.LightBlue
import com.marbjorn.mega_igrasu.ui.theme.Navy

@Composable
fun HostScreen() {
    val currentScreen = remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        containerColor = LightBlue,
        topBar = {
            TopBar(modifier = Modifier.background(Navy).fillMaxWidth()) {
                MenuItem(modifier = Modifier, isSelected = currentScreen.intValue == 0, imageId = R.drawable.shopping_bag) {
                    // TODO
                }
                MenuItem(modifier = Modifier, isSelected = currentScreen.intValue == 1, imageId = R.drawable.shopping_cart) {
                    // TODO
                }
                MenuItem(modifier = Modifier, isSelected = currentScreen.intValue == 2, imageId = R.drawable.user) {
                    // TODO
                }
            }
        }
    ) {
        it
        when (currentScreen.value) {
            0 -> {
                CatalogScreen(
                    modifier = Modifier.padding(it).fillMaxSize(),
                    list = mutableListOf(Game("1", "A", "B", 19.99)),
                    currentPage = 0,
                    onAddToCartClick = { /*TODO*/ },
                    onNextClick = { /*TODO*/ }) {

                }
            }
        }
    }

}

@Composable
@Preview
private fun HostScreenPreview() {
    HostScreen()
}
