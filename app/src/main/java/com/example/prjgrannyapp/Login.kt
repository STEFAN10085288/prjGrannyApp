package com.example.prjgrannyapp

import android.util.Log

private var aName =  ArrayList<String>()
private var aPassword= ArrayList<String>()
class Login
{
    fun AddOldUsers()
    {
        aName.add("Granny")
        aPassword.add("Tim")
        aName.add("Granpa")
        aPassword.add("Timmy")
        aName.add("Timmy")
        aPassword.add("Granny")

    }
    fun AddNewUser(Name :String,Password:String)
    {
        Log.d("AddNewUser","Name was :"+Name+" and Password was :"+Password)
        aName.add(Name)
        aPassword.add(Password)
    }
    fun checkUser(Name :String,Password:String):Boolean
    {
        var bLoop =false
        for (i in 0..aName.size-1)
        {
            if ((aPassword[i].equals(Password))&&(aName[i].equals(Name)))
            {
                bLoop=true
            }
        }
        return bLoop
    }

}