package ke.co.fiti.foodexpress.presentation.navigation


sealed class Screen(
    val route: String
) {
    object Home : Screen(
        route = Routes.HOME.name
    )

    object CreateAccount : Screen(
        route = Routes.CREATEACCOUNT.name
    )

    object Login : Screen(
        route = Routes.LOGIN.name
    )

    object Settings : Screen(
        route = Routes.SETTINGS.name
    )
    object Loading : Screen(
        route = Routes.LOADING.name
    )
    object Orientation : Screen(
        route = Routes.ORIENTATION.name
    )
    object Onboarding: Screen(
        route = Routes.ONBOARDING.name
    )

}


enum class Routes {
    ONBOARDING,ORIENTATION,HOME, CREATEACCOUNT, LOGIN, SETTINGS,LOADING


}
