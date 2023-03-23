package com.example.prjgrannyapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Welcome : AppCompatActivity()
{
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val feed : RecyclerView = findViewById(R.id.Feed)
        userAdapter= UserAdapter()
        feed.apply {
            layoutManager = LinearLayoutManager(this@Welcome)
            adapter = userAdapter
        }
        val Items = mutableListOf<User>()
        for (i in 0..40) {
            Items.add(
                User(
                    Name = "Name test $i",
                    Password = "Password $i",
                    imageURL = "https://picsum.photos/200/300"
                )
            )
        }
        userAdapter.submitList(Items)


    }
}