package com.example.prjgrannyapp

class Login
{
    private var aName =  ArrayList<String>()
    private var aPassword= ArrayList<String>()

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
        aName.add(Name)
        aPassword.add(Password)
    }
    fun checkUser(Name :String,Password:String):Boolean
    {
        var bLoop =false
        for (i in 0..aName.size)
        {
            if ((aPassword[i].equals(Password))&&(aName[i].equals(Name)))
            {
                bLoop=true
            }
        }
        return bLoop
    }

}