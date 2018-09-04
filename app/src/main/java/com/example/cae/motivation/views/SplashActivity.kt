package com.example.cae.motivation.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cae.motivation.R
import com.example.cae.motivation.util.AppConstants
import com.example.cae.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        mSecurity = SecurityPreferences(this)

        buttonSave.setOnClickListener(this)
    }

    private lateinit var mSecurity : SecurityPreferences

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name: String = editName.text.toString()

        if (name == "") {
            Toast.makeText(this, getString(R.string.notice_no_name), Toast.LENGTH_LONG).show()
        } else {
            mSecurity.storeString(AppConstants.KEY.PERSON_NAME, name)

            val intent: Intent = Intent(this, MainActivity::class.java) //a classe que temos a intenção de abrir, por isso o uso de ::, pois não é uma instância, mas sim uma referência
            startActivity(intent)
        }

    }

}
