package com.example.myfirstfirebaseproject

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

fun MainActivity.readobj()
{
    val myUid=MainActivity.auth.currentUser!!.uid
    val myListener=object:ValueEventListener
    {
        override fun onDataChange(snapshot: DataSnapshot) {
//            this time we don't know the which time we would have to take snapshot
            Log.i("TAG",snapshot.value.toString())
//            data snapshot is seen like
//            {key=,value={uid=,name=,email=}}
            val readvalue=snapshot.value as Map<String,Any>
//            key should be string and val can be anything
            val name=readvalue["name"]
            val uid=readvalue["uid"]
            val  email=readvalue["email"]
            val fetchedUser=User(name.toString(),email.toString(),uid.toString())
            Message("We found ${fetchedUser.name}")

        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    }
    MainActivity.database.reference.child("users").child(myUid)
        .addListenerForSingleValueEvent(myListener)

//    Another Method like reading a simple data
//    MainActivity.database.reference.child("users")
//        .child("myUid").addListenerForSingleValueEvent(object:ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                Log.i("TAG",snapshot.value.toString())
////            data snapshot is seen like
////            {key=,value={uid=,name=,email=}}
//                val readvalue=snapshot.value as Map<String,Any>
////            key should be string and val can be anything
//                val name=readvalue["name"]
//                val uid=readvalue["uid"]
//                val  email=readvalue["email"]
//                val fetchedUser=User(name.toString(),email.toString(),uid.toString())
//                Message("We found ${fetchedUser.name}")
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })

}