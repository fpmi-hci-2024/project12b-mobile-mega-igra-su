package com.marbjorn.mega_igrasu.ui.component

import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.marbjorn.mega_igrasu.R
import com.marbjorn.mega_igrasu.ui.theme.Cyan

@Composable
fun MenuItem(
    modifier: Modifier,
    isSelected: Boolean,
    imageId: Int,
    callback: () -> Unit
) {
    Image(
        painter = painterResource(id = imageId),
        colorFilter = ColorFilter.tint(color = if (isSelected) Cyan else Color.White),
        contentDescription = "item",
        modifier = modifier.clickable {
            callback()
        }
    )
}

@Preview
@Composable
private fun MenuItemPreview() {
    MenuItem(
        Modifier,
        true,
        R.drawable.user
    ) { }
}
