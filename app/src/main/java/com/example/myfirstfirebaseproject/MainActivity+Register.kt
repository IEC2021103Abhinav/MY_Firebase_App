package com.example.myfirstfirebaseproject

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.UserProfileChangeRequest

fun MainActivity.registeration()
{
//    Complete registration hone ke baad ke kya karna hai -->two chance if succesful registration and unsuccessful
//    that is done by AddOn CompleteListener
    MainActivity.auth.createUserWithEmailAndPassword(MainActivity.EMAIL,MainActivity.PASS)
        .addOnCompleteListener(this){task->
            if(task.isSuccessful)
            {
//                for any change in the profile
                val ProfileUpdates=UserProfileChangeRequest.Builder()
                    .setDisplayName(MainActivity.NAME)
                    .build()
//                as it is in successful if condition ,it is happened when a user exist only
//                that why currentUser!! update profile from(ProfileUpdates)
                MainActivity.auth.currentUser!!.updateProfile(ProfileUpdates)
//                Toast.makeText(this,"Registration Successful",Toast.LENGTH_LONG).show()
                Message("Registration Successful")
            }
            else
            {
//                Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show()
                Message("Registration Failed")
//                what is the reason for failed ,we have to show by LOG CAT
                Log.i("TAG",task.exception.toString())

            }
        }

}