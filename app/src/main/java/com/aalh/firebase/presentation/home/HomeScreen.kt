package com.aalh.firebase.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aalh.firebase.presentation.model.Artist
import com.aalh.firebase.ui.theme.Black

@Composable
fun HomeScreen(viewmodel: HomeViewmodel = HomeViewmodel()) {
    val artists = viewmodel.artist.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        Text(
            "Popular Artist",
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(artists.value) {
                ArtistItem(it)
            }
        }
    }
}

@Composable
fun ArtistItem(artist: Artist) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier.size(60.dp).clip(CircleShape),
            model = artist.image,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(artist.name.orEmpty(), color = Color.White)
    }
}


/*data class Artist(
    val name: String,
    val numberOfSongs: Int
)

fun createArtist(db: FirebaseFirestore) {
    val random = (1..100).random()
    val artist = Artist(name = "Random $random", numberOfSongs = random)
    db.collection("artists").add(artist)
        .addOnSuccessListener { Log.d("LEON", "Success") }
        .addOnFailureListener { Log.d("LEON", "FAILURE") }
        .addOnCompleteListener { Log.d("LEON", "Complete") }
}*/