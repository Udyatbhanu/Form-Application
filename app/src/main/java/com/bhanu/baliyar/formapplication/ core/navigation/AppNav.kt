package com.bhanu.baliyar.formapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhanu.baliyar.formapplication.presentation.screens.HomeScreen
import com.bhanu.baliyar.formapplication.presentation.screens.Recipe
import com.bhanu.baliyar.formapplication.presentation.screens.RecipeDetailsScreen



val sampleRecipe = Recipe(
    id = 11,
    name = "Chicken Biryani",
    ingredients = listOf(
        "Basmati rice", "Chicken, cut into pieces", "Onions, thinly sliced",
        "Tomatoes, chopped", "Yogurt", "Ginger-garlic paste", "Biryani masala",
        "Green chilies, sliced", "Fresh coriander leaves", "Mint leaves", "Ghee", "Salt to taste"
    ),
    instructions = listOf(
        "Marinate chicken with yogurt, ginger-garlic paste, biryani masala, and salt.",
        "In a pot, sauté sliced onions until golden brown. Remove half for later use.",
        "Layer marinated chicken, chopped tomatoes, half of the fried onions, and rice in the pot.",
        "Top with ghee, green chilies, fresh coriander leaves, mint leaves, and the remaining fried onions.",
        "Cover and cook on low heat until the rice is fully cooked and aromatic.",
        "Serve hot, garnished with additional coriander and mint leaves."
    ),
    prepTimeMinutes = 30,
    cookTimeMinutes = 45,
    servings = 6,
    difficulty = "Medium",
    cuisine = "Pakistani",
    caloriesPerServing = 550,
    tags = listOf("Biryani", "Chicken", "Main course", "Indian", "Pakistani", "Asian"),
    userId = 133,
    image = "https://cdn.dummyjson.com/recipe-images/11.webp",
    rating = 5,
    reviewCount = 32,
    mealType = listOf("Lunch", "Dinner")
)
@Composable
fun AppNav(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Route.Home.route
    ) {
        composable(Route.Home.route) {
            HomeScreen()
        }
        composable(Route.Details.route) {
            RecipeDetailsScreen(recipe = sampleRecipe)
        }
    }
}