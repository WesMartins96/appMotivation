package com.example.appmotivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.appmotivation.R
import com.example.appmotivation.infra.MotivationConstants
import com.example.appmotivation.infra.SecurityPreferences
import com.example.appmotivation.repository.Mock


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mFraseFiltro : Int = MotivationConstants.FRASE.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        val textName = findViewById<TextView>(R.id.textName)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        textName.text = "Olá, $name!"


        // Logica inicial de seleção
        val img_all1 = findViewById<ImageView>(R.id.img_all)
        img_all1.setColorFilter(resources.getColor(R.color.teal_200))
        handleNovaFrase()


        val btn_nFrase = findViewById<Button>(R.id.btn_nFrase)
        btn_nFrase.setOnClickListener(this)
        val img_all = findViewById<ImageView>(R.id.img_all)
        img_all.setOnClickListener(this)
        val img_happy = findViewById<ImageView>(R.id.img_happy)
        img_happy.setOnClickListener(this)
        val img_morning = findViewById<ImageView>(R.id.img_morning)
        img_morning.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        val listFiltro = listOf(R.id.img_all, R.id.img_happy, R.id.img_morning)

        if (id == R.id.btn_nFrase) {
            handleNovaFrase()
        } else if (id in listFiltro) {
            handleFiltro(id)
        }

    }

    private fun handleFiltro(id: Int) {

        val img_all = findViewById<ImageView>(R.id.img_all)
        img_all.setColorFilter(resources.getColor(R.color.teal_200))

        val img_happy = findViewById<ImageView>(R.id.img_happy)
        img_happy.setColorFilter(resources.getColor(R.color.teal_200))

        val img_morning = findViewById<ImageView>(R.id.img_morning)
        img_morning.setColorFilter(resources.getColor(R.color.teal_200))

        when (id) {
            R.id.img_all -> {
                val img_all = findViewById<ImageView>(R.id.img_all)
                img_all.setColorFilter(resources.getColor(R.color.icon))
                mFraseFiltro = MotivationConstants.FRASE.ALL
            }
            R.id.img_happy -> {
                val img_happy = findViewById<ImageView>(R.id.img_happy)
                img_happy.setColorFilter(resources.getColor(R.color.icon))
                mFraseFiltro = MotivationConstants.FRASE.HAPPY
            }
            R.id.img_morning -> {
                val img_morning = findViewById<ImageView>(R.id.img_morning)
                img_morning.setColorFilter(resources.getColor(R.color.icon))
                mFraseFiltro = MotivationConstants.FRASE.MORNING
            }
        }
    }

    private fun handleNovaFrase() {
        val textFrases = findViewById<TextView>(R.id.textFrases)
        textFrases.text = Mock().getFrase(mFraseFiltro)
    }

}