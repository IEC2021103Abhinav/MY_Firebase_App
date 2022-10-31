package com.example.myfirstfirebaseproject

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

fun MainActivity.readsimple()
{
    MainActivity.database.reference.child("data")
        .child("tests").addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val fetchedValue=snapshot.value.toString()
                Message("Found $fetchedValue")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

}