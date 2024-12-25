package com.marbjorn.mega_igrasu.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marbjorn.mega_igrasu.R
import com.marbjorn.mega_igrasu.ui.theme.juaFamily

@Composable
fun TopBar(modifier: Modifier, icons: @Composable () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                modifier = Modifier.size(36.dp, 36.dp),
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "logo"
            )
            Text(
                text = "Mega-igra.su",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
                fontFamily = juaFamily
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            icons()
        }
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar(Modifier) {
        MenuItem(modifier = Modifier.padding(horizontal = 8.dp), isSelected = false, imageId = R.drawable.shopping_bag) {}
        MenuItem(modifier = Modifier.padding(horizontal = 8.dp), isSelected = true, imageId = R.drawable.shopping_cart) {}
        MenuItem(modifier = Modifier.padding(horizontal = 8.dp), isSelected = false, imageId = R.drawable.user) {}
    }
}