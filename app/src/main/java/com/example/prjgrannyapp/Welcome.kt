package com.example.prjgrannyapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.net.URL
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Welcome : AppCompatActivity()
{


    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val feed : RecyclerView = findViewById(R.id.Feed)
        userAdapter= UserAdapter()
        feed.apply {
            layoutManager = LinearLayoutManager(this@Welcome)
            adapter = userAdapter
        }
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        //uses thread to upload from url
        val executor =  Executors.newSingleThreadExecutor()
        executor.execute {
            val url = URL("https://wordapidata.000webhostapp.com/?getuserdb")
            val json = url.readText()
            //implementation on gradle for GSON
            val userList = Gson().fromJson(json, Array<User>::class.java).toList()

            Handler(Looper.getMainLooper()).post {
                Log.d("AddNewUser", "Plain Json Vars :$json")
                Log.d("AddNewUser", "Converted Json :$userList")
                userAdapter.submitList(userList)
                progressBar.visibility=View.GONE
            }
            }

        userAdapter.onItemClick = {
            val intent = Intent(this,Detailed_item_activity::class.java)
            intent.putExtra("user",it)
            startActivity(intent)
        }
        }
    }
