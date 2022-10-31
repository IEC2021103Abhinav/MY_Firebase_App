package com.example.myfirstfirebaseproject

import android.util.Log

//by giving mainActivity extension
//we can do the when if else statement in main activity
fun MainActivity.login()
{
    MainActivity.auth.signInWithEmailAndPassword(MainActivity.EMAIL,
        MainActivity.PASS).addOnCompleteListener(this){task->
            if(task.isSuccessful)
            {
                val username=MainActivity.auth.currentUser!!.displayName
                Message("Welcome back $username")
            }
            else
            {
                Message("Login Failed!!")
//                what is the reason for login failed
                Log.i("TAG",task.exception.toString())
//                by this we can show the user different types of error what is happened
            }
    }

}