package com.example.prjgrannyapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        //declaring and setting the imageview
        val imageView = findViewById<ImageView>(R.id.imageView)

        //Declaring executor to parse the url
        val executor = Executors.newSingleThreadExecutor()

        val handler = Handler(Looper.getMainLooper())

        //initializing the image
        var image: Bitmap?= null

        executor.execute{
            //image url
            val imageUrl= "https://picsum.photos/200/300"
            //Tries to get the image and post
            // it in the imageview with the help of the handler
            try {
                    val `in` = java.net.URL(imageUrl).openStream()
                    image = BitmapFactory.decodeStream(`in`)
                    Log.d("AddNewUser","Image in text"+image.toString())
                    //only for making changes in UI
                    handler.post {
                        Log.d("AddNewUser","Image added")
                        imageView.setImageBitmap(image)
                    }

                }
            catch (e:java.lang.Exception)
            {
                Log.d("AddNewUser","Error happened "+e.toString())
                e.printStackTrace()
            }
        }

    }
}