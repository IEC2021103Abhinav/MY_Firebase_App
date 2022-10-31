package com.example.myfirstfirebaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object
    {
        lateinit var auth:FirebaseAuth
//        For register we want three objects
        const val EMAIL="luciferabhinavdevil666@gmail.com"
        const val NAME="Abhinav A"
        const val PASS="Jerry@112002"
//        now go to register activity and do the register part

//        for accessing the root node of realtime database console  where we write the data
        val database=Firebase.database
    }

    val registerbtn=findViewById<Button>(R.id.registerbutton)
    val loginbtn=findViewById<Button>(R.id.loginbutton)
    val writesimpdatabtn=findViewById<Button>(R.id.writesmpldatabtn)
    val readsimpdatabtn=findViewById<Button>(R.id.readsmpldatabtn)
    val writeobjectbtn=findViewById<Button>(R.id.writeobjectbtn)
    val readobjbtn=findViewById<Button>(R.id.readobjectbtn)
    val readmanyobjbtn=findViewById<Button>(R.id.readmanyobjectsbtn)
    val writemnyobjbtn=findViewById<Button>(R.id.writemanyobjectsbtn)
    val readcontinuouslybtn=findViewById<Button>(R.id.readcontinuouslybtn)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        as we have initializtion in the lateinit var we have to
//        initialise here like this

        auth=FirebaseAuth.getInstance()
        registerbtn.setOnClickListener(this)
        readsimpdatabtn.setOnClickListener(this)
        writesimpdatabtn.setOnClickListener(this)
        readmanyobjbtn.setOnClickListener(this)
        writemnyobjbtn.setOnClickListener(this)
        loginbtn.setOnClickListener(this)
        readobjbtn.setOnClickListener(this)
        writeobjectbtn.setOnClickListener(this)
        readcontinuouslybtn.setOnClickListener(this)
//        this means registration will be on the present page

    }

    override fun onClick(buttton: View?) {
        when(buttton!!.id)
        {
            R.id.loginbutton->login()
            R.id.registerbutton->registeration()

            R.id.readsmpldatabtn->readsimple()
            R.id.writesmpldatabtn->writesimple()

            R.id.readobjectbtn->readobj()
            R.id.writeobjectbtn->writeobj()

            R.id.readmanyobjectsbtn->readmanyobj()
            R.id.writemanyobjectsbtn->writemanyobj()

            R.id.readcontinuouslybtn->readcont()

        }

    }

}
//this func for showing message in the toast
fun MainActivity.Message(message: String)
{
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}