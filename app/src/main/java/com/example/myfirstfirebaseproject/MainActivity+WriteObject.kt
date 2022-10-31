package com.example.myfirstfirebaseproject

import com.google.firebase.database.DatabaseReference

fun MainActivity.writeobj()
{
//    uid-->Unique Identification
    val myName=MainActivity.auth.currentUser!!.displayName
    val myEmail=MainActivity.auth.currentUser!!.email
    val myUid=MainActivity.auth.currentUser!!.uid
    val myUser=User(myName!!,  myEmail!!,myUid)
    val completionListener=DatabaseReference.CompletionListener { error, ref ->
        if (error==null)
        {
        }
        else
        {
        }
    }
//   write database to it my backend users
    MainActivity.database.getReference("users").child(myUid)
        .setValue(myUser,completionListener)


//    Other method
//    by this func we gt a node of name users and in that there is a child of name -->muUid value
//    in which all the value of myUser will written
//    when the email and the  password is same then uid comes into work
//    for security--> root node->users->uid(which is not known any one)
//    MainActivity.database.getReference("users").child("myUid")
//        .setValue("myUser",DatabaseReference.CompletionListener { error, _ ->
//            if(error==null)
//            {
//                Message("Object Written Successfully")
//            }
//            else
//            {
//                Message("Error Happened")
//            }
//        })
}