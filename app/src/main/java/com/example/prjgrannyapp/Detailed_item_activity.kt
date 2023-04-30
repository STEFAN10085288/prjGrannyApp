package com.example.prjgrannyapp

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.Executors

class Detailed_item_activity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_item)

        val user = intent.getParcelableExtra<User>("user")
        val executor = Executors.newSingleThreadExecutor()

        if (user != null)
        {
            val textViewName : TextView = findViewById(R.id.txtDetailName)
            val textViewPassword : TextView = findViewById(R.id.txtDetailPassword)
            val handler = Handler(Looper.getMainLooper())

            var image: Bitmap? = null
            val imageViewPP : ImageView = findViewById(R.id.imDetailPP)

            textViewName.text = "Name: ${user.Name}"
            textViewPassword.text = "Password: ${user.Password}"

            /*val `in` = java.net.URL(user.imageURL).openStream()
            image = BitmapFactory.decodeStream(`in`)
            imageViewPP.setImageBitmap(image)*/

            executor.execute {
                //image url
                val imageUrl = user.imageURL// added this
                //Tries to get the image and post it in the imageview with the help of the handler
                try {
                    val `in` = java.net.URL(imageUrl).openStream()
                    image = BitmapFactory.decodeStream(`in`)
                    Log.d("AddImage", "Image in text" + image.toString())
                    //only for making changes in UI
                    handler.post {
                        Log.d("AddImage", "Image added")
                        imageViewPP.setImageBitmap(image)
                    }

                } catch (e: java.lang.Exception) {
                    Log.d("AddImage", "Error happened $e")
                    e.printStackTrace()
                }
            }
        }


    }
}