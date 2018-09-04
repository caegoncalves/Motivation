package com.example.cae.motivation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        val id = view.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name: String = editName.text.toString()
        mSecurity.storeString(AppConstants.KEY.PERSON_NAME, name)

    }

}
