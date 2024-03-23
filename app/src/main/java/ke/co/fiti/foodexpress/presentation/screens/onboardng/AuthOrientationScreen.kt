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
import ke.co.fiti.foodexpress.presentation.screens.onboardng.util.ButtonWitoutIcon
import ke.co.fiti.foodexpress.presentation.screens.onboardng.util.OnboardingFancyImage
import ke.co.fiti.foodexpress.presentation.screens.onboardng.util.TitleWithDescription

@Composable
fun AuthOrientationScreen(
    navigateToLoginScreen: () -> Unit,
    navController: NavHostController,
    navigateToCreateAccountScreen: () -> Unit
) {
    Scaffold { PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())

        ) {
            OnboardingFancyImage(image = R.drawable.chips)
            Spacer(modifier = Modifier.height(12.dp))
            TitleWithDescription(
                titleText = "Food Express",
                descriptionText = "Get the fastest delivery  for you!"
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.35F))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Column {
                    Row (Modifier.fillMaxWidth(0.65F)){
                        ButtonWitoutIcon(buttonText = "Create Account", onClick = {})
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    ButtonWitoutIcon(buttonText = "Login", onClick = {})
                }
            }


        }

    }

}