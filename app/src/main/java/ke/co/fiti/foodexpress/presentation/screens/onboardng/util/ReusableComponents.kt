package ke.co.fiti.foodexpress.presentation.screens.onboardng.util

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingFancyImage(
    @DrawableRes image: Int
) {
    Box(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    bottomStart = 200.dp,
                    bottomEnd = 200.dp
                )
            )
            .fillMaxHeight(0.65F)
            .fillMaxSize()
            .background(color = Color.Green)
    ) {
        Image(
            painter = painterResource(id = image),
            modifier = Modifier
                .fillMaxSize(),

            contentDescription = null,
            contentScale = ContentScale.Crop

        )
    }

}

@Composable
fun TitleWithDescription(
    titleText: String,
    descriptionText: String
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = titleText)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = descriptionText, modifier = Modifier.padding(horizontal = 20.dp))

    }


}


@Composable
fun ButtonWithIcon(
    buttonText: String,
    @DrawableRes buttonImage: Int,
    onClick: () -> Unit = {},

    ) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(25.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.75F),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = buttonText)
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = buttonImage),
                contentDescription = null,
            )

        }
    }

}

@Composable
fun ButtonWitoutIcon(
    buttonText: String,
    onClick: () -> Unit = {},

    ) {

        Button(
            onClick = onClick,
            shape = RoundedCornerShape(25.dp),
            contentPadding = PaddingValues(20.dp)
        ) {
            Text(text = buttonText)
        }



}