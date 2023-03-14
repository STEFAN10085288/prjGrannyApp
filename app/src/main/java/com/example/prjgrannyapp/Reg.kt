package com.example.prjgrannyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Reg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        var btnReg: Button = findViewById(R.id.btnReg)
        btnReg.setOnClickListener()
        {
            var txtName: EditText = findViewById(R.id.txtNameReg)
            var txtPassword: EditText =findViewById(R.id.txtPasswordReg)
            val log = Login()
            log.AddOldUsers()
            Log.d("AddNewUser","Pressed the reg button")
            log.AddNewUser(txtName.text.toString()
                ,txtPassword.text.toString())

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

        }
        var btnReturn: Button = findViewById(R.id.btnReturn)
        btnReturn.setOnClickListener()
        {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}