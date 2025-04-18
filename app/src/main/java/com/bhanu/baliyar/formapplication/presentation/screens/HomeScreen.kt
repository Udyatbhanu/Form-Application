package com.bhanu.baliyar.formapplication.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.bhanu.baliyar.formapplication.core.LocalSpacing
import com.bhanu.baliyar.formapplication.core.navigation.Route


data class Item(val title: String, val imageUrl: String)

val gridItems = mutableListOf<Item>(
    Item(
        title = "Mountains",
        imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb"
    ),
    Item(title = "Sun", imageUrl = "https://images.unsplash.com/photo-1502082553048-f009c37129b9"),
    Item(
        title = "Forest",
        imageUrl = "https://images.unsplash.com/photo-1501785888041-af3ef285b470"
    )
)


@Composable
fun HomeScreen() {
    GridView()
}


data class NavRoutes(val name: String, val route: Route)


val screenRoutes = listOf<NavRoutes>(
    NavRoutes(name = "Home", route = Route.Home),
    NavRoutes(name = "Favorites", route = Route.Details)
)


@Composable
fun BottomNav(navController: NavController, currentRoute: String?) {
    val localSpacing = LocalSpacing.current
    NavigationBar {

        screenRoutes.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route.route,
                onClick = {
                    if (currentRoute != screen.route.route) {
                        navController.navigate(screen.route.route)
                    }
                },
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home") }
            )
        }
//        NavigationBarItem(
//            selected = currentRoute == Route.Home.route,
//            onClick = {
//                if (currentRoute != Route.Home.route) {
//                    navController.navigate(Route.Home.route)
//                }
//            },
//            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//            modifier = Modifier.padding(localSpacing.large),
//            label = { Text("Home") }
//        )
//        NavigationBarItem(
//            selected = currentRoute == Route.Details.route,
//            onClick = {
//                if (currentRoute != Route.Details.route) {
//                    navController.navigate(Route.Details.route)
//                }
//            },
//            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
//            modifier = Modifier.padding(localSpacing.large),
//            label = { Text("Favorites") }
//        )
    }
}

@Composable
fun GridView(modifier: Modifier = Modifier) {
    val localSpacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(localSpacing.medium),
    ) {
        LazyHorizontalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            rows = GridCells.Fixed(1),
            contentPadding = PaddingValues(4.dp),
        ) {
            items(gridItems) { item ->
                ItemCard(item)
            }

        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        content = {
            Column {
                AsyncImage(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    model = item.imageUrl,
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.Start),
                    text = item.title,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    )
}

