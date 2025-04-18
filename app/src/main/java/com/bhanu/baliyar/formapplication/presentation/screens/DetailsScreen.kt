package com.bhanu.baliyar.formapplication.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import coil3.compose.AsyncImage
import com.bhanu.baliyar.formapplication.core.LocalSpacing


data class Recipe(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val difficulty: String,
    val cuisine: String,
    val caloriesPerServing: Int,
    val tags: List<String>,
    val userId: Int,
    val image: String,
    val rating: Int,
    val reviewCount: Int,
    val mealType: List<String>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(recipe: Recipe) {
    val spacing = LocalSpacing.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.medium)
    ) {
        item {
            // 🖼 Recipe Image
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(spacing.large)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(spacing.large))
        }

        item {
            // 🧾 Metadata Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(spacing.medium)) {
                    Text("Cuisine: ${recipe.cuisine}", style = MaterialTheme.typography.bodyMedium)
                    Text("Difficulty: ${recipe.difficulty}", style = MaterialTheme.typography.bodyMedium)
                    Text("Prep Time: ${recipe.prepTimeMinutes} min", style = MaterialTheme.typography.bodyMedium)
                    Text("Cook Time: ${recipe.cookTimeMinutes} min", style = MaterialTheme.typography.bodyMedium)
                    Text("Calories/Serving: ${recipe.caloriesPerServing}", style = MaterialTheme.typography.bodyMedium)
                    Text("Servings: ${recipe.servings}", style = MaterialTheme.typography.bodyMedium)
                    Text("Rating: ⭐ ${recipe.rating} (${recipe.reviewCount} reviews)", style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(spacing.large))
        }

        item {
            // 🧂 Ingredients Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(spacing.medium)) {
                    Text("Ingredients", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.ingredients.forEach {
                        Text("• $it", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 4.dp, top = 2.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(spacing.large))
        }

        item {
            // 👨‍🍳 Instructions Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(spacing.medium)) {
                    Text("Instructions", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.instructions.forEach {
                        Text("• $it", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 4.dp, top = 2.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(spacing.large))
        }

        item {
            // 🏷 Tags
            Text(
                "Tags: ${recipe.tags.joinToString(", ")}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = spacing.medium)
            )
            Text(
                "Meal Type: ${recipe.mealType.joinToString(", ")}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}