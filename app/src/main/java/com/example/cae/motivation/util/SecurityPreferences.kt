package com.example.cae.motivation.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE) //MODE.PRIVATE diz que os dados não serão compartilhados com outras aplicações

    fun storeString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getStoredString(key: String): String {
        return sharedPreferences.getString(key, "") //string vazia será o retorno default caso não encontre a key
    }
}