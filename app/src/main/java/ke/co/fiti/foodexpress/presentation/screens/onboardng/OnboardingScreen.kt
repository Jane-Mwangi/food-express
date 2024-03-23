package ke.co.fiti.foodexpress.presentation.screens.onboardng

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ke.co.fiti.foodexpress.R
import ke.co.fiti.foodexpress.presentation.screens.onboardng.util.ButtonWithIcon
import ke.co.fiti.foodexpress.presentation.screens.onboardng.util.OnboardingFancyImage
import ke.co.fiti.foodexpress.presentation.screens.onboardng.util.TitleWithDescription

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Scaffold { PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {

                OnboardingFancyImage(image = R.drawable.chicke)

            Spacer(modifier = Modifier.fillMaxHeight(0.075F))
            TitleWithDescription(
                titleText = "Are you hungry?",
                descriptionText = "Order food and get delivery within few minutes to your door."
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.4F))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                ButtonWithIcon(
                    buttonText = "Get Started",
                    buttonImage = R.drawable.vector,
                    onClick = {
                        TODO()
                    })
            }


        }

    }
}


