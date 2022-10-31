package com.example.myfirstfirebaseproject

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

fun MainActivity.readmanyobj()
{
    val  myUid:String=MainActivity.auth.currentUser!!.uid
//    go to the my database ref to the particular myUid and then go to the items of it and then get the snapshot
//    from there basically read the values,and then print it and see which type of data is present
//    then they go to the values for the name and city and then put inside the new item and then new item is added
//    into ItemsArray
    MainActivity.database.reference.child("myUid").child("items")
        .addListenerForSingleValueEvent(
            object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.i("TAG",snapshot.value.toString())
//                    by log cat we can see the snapshot value which is to be read and they are of which type

                    val readItems=
                        snapshot.value as Map<String,Map<String,String>>
                    var itemsArray= arrayListOf<Item>()
                    for(each in readItems.values)
                    {
                        val name=each["name"]
                        val city=each["city"]

                        val newItem=Item(name!!,city!!)
                        itemsArray.add(newItem)
                    }
                    Message("We Found ${itemsArray.count()} items")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

}