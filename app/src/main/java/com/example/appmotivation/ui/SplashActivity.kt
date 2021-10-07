package com.example.appmotivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.appmotivation.R
import com.example.appmotivation.infra.MotivationConstants
import com.example.appmotivation.infra.SecurityPreferences


class SplashActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        findViewById<Button>(R.id.bt_Save).setOnClickListener(this)

        verifyName()


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.bt_Save){
            handleSave()
        }
    }

    private fun verifyName(){
       val name =  mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun handleSave(){
        val name = findViewById<EditText>(R.id.edit_name).text.toString()

        if (name != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        }else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_LONG).show()
        }
    }
}