package com.example.myfirstfirebaseproject

import android.util.Log
import com.google.firebase.database.DatabaseReference

fun MainActivity.writesimple()
{
//    writing a value into a single node in  realtime database firebase
//    we need to able to access the root node where we can write the data
//    for this we have to go to main activity and add in companion object
//   val database=firebase.database

//    go to database rootnode and get the data node and add  a child test if it is not exist then write a vlue for
//    it "this is from android" and then get the completion listener of that  and listener tell us about error then
//    if not error then they give refernce to what they have just written  in this case our ref -->rootnode datatest

    MainActivity.database.getReference("data").child("test")
        .setValue("This is from Android",DatabaseReference.CompletionListener {
                error, ref ->
            if(error==null)
            {
                Message("Wrote Successfully")
            }
            else
            {
                Message("Database Error")

            }

        })


}