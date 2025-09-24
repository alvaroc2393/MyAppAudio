package com.example.myapp


import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
private var mediaPlayer: MediaPlayer? = null


// Mapear ImageView id -> raw resource id
private val mapping = mapOf(
R.id.img1 to R.raw.a1,
R.id.img2 to R.raw.a2,
R.id.img3 to R.raw.a3,
R.id.img4 to R.raw.a4,
R.id.img5 to R.raw.a5,
R.id.img6 to R.raw.a6,
R.id.img7 to R.raw.a7,
R.id.img8 to R.raw.a8
)


override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)


// Asignar listeners a cada ImageView
for ((imgId, rawId) in mapping) {
val iv = findViewById<ImageView>(imgId)
iv.setOnClickListener {
playSound(rawId)
}
}
}


private fun playSound(resId: Int) {
// liberar si hay uno sonando
mediaPlayer?.let {
it.stop()
it.release()
}
mediaPlayer = MediaPlayer.create(this, resId)
mediaPlayer?.start()
// liberar al terminar
mediaPlayer?.setOnCompletionListener { mp ->
mp.release()
if (mediaPlayer === mp) mediaPlayer = null
}
}


override fun onPause() {
super.onPause()
mediaPlayer?.let {
it.stop()
it.release()
mediaPlayer = null
}
}
}
