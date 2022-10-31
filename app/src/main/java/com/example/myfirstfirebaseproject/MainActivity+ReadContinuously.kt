package com.example.myfirstfirebaseproject

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

fun MainActivity.readcont()
{
//    opening a channel to keeping an eye on changes
//    channel points to particular location and sees the values continuously
//    here we change only we addValueEvent listener which is taking the snapshot and reading the values untill
//    u don,t want to stop
//    it read over the values and the values,constant listening after changing the data
    MainActivity.database.reference.child("city")
        .addValueEventListener(
            object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val value = snapshot.value.toString()
                    Message("Found $value")
//              if we change the data then the message  Found "City"seen in the app automatically to the user
//                    because it constantly read the data
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

}