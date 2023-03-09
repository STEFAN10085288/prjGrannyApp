package com.example.prjgrannyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnLogin:Button = findViewById(R.id.button)
        btnLogin.setOnClickListener()
        {
            var txtName:EditText = findViewById(R.id.txtName)
            var txtPassword:EditText =findViewById(R.id.txtPassword)
            Login().AddOldUsers()
            var Shouldbeallowedin:Boolean =Login().checkUser(txtName.text.toString()
                ,txtPassword.text.toString())
            if (Shouldbeallowedin)
            {
                val intent = Intent(this,Welcome::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Wrong details entered or" +
                        " else I did something wrong #rest if for homework :) ",Toast.LENGTH_SHORT).show()
            }

        }

    }
}