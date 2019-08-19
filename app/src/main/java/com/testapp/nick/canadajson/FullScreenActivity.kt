package com.testapp.nick.canadajson

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class FullScreenActivity : AppCompatActivity() {

    lateinit var myImage: ImageView
    var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_image)
        url = intent.getStringExtra("image_url")
        myImage = findViewById(R.id.myImage)
        myImage.setImageResource(R.mipmap.ic_launcher_foreground)
        if(url != null && url!!.isNotEmpty()) {
            Glide.with(this).load(url)
                .placeholder(R.mipmap.ic_launcher_foreground)
                .error(R.mipmap.ic_launcher_foreground)
                .into(myImage)
        }
    }
}