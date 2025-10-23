package com.aalh.firebase.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aalh.firebase.presentation.model.Artist
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeViewmodel : ViewModel() {
    private var db: FirebaseFirestore = Firebase.firestore

    private val _artist = MutableStateFlow<List<Artist>>(emptyList())
    val artist: StateFlow<List<Artist>> = _artist

    init {
        /*repeat(20) {
            loadData()
        }*/
        getArtist()
    }

    private fun loadData() {
        val random = (1..100).random()
        val artist = Artist(
            name = "Random $random",
            description = "Descripcion random numero $random",
            image = "https://rare-gallery.com/mocahbig/42266-Danny-Phantom-HD-Wallpaper.jpg"
        )
        db.collection("artists").add(artist)
    }

    private fun getArtist() {
        viewModelScope.launch {
            val result: List<Artist> = withContext(Dispatchers.IO) {
                getAllArtist()
            }
            _artist.value = result
        }
    }

    suspend fun getAllArtist(): List<Artist> {
        return try {
            db.collection("artists")
                .get()
                .await()
                .documents
                .mapNotNull { documentSnapshot ->
                    documentSnapshot.toObject(Artist::class.java)
                }
        } catch (e: Exception) {
            Log.i("LEON", e.toString())
            emptyList()
        }
    }
}