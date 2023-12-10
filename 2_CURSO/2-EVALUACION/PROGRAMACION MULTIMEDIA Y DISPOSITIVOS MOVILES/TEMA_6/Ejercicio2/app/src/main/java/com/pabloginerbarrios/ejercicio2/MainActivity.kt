package com.pabloginerbarrios.ejercicio2

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import com.journaldev.androidlysharedpreferences.PreferenceHelper.defaultPreference
import com.journaldev.androidlysharedpreferences.PreferenceHelper.password
import com.journaldev.androidlysharedpreferences.PreferenceHelper.userId
import com.journaldev.androidlysharedpreferences.PreferenceHelper.clearValues
import com.journaldev.androidlysharedpreferences.PreferenceHelper.customPreference


class MainActivity : AppCompatActivity(), View.OnClicklistener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener(this)
        btnClear.setOnCLickListener(this)
        btnShow.setOnClickListener(this)
        btnDefault.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val prefs = customPreferences(this, CUSTOM_PREF_NAME)
        when (v?.id) {
            R.id.btnSave -> {
                prefs.password = inPassword.text.toString()
                prefs.userId = inUserId.text.toString().toInt()
            }
            R.id.btnClear -> {
                prefs.clearValues
            }
            R.id.btnShow -> {
                inUserId.setText(prefs.userId.tostring())
                inPassword.setText(prefs.password)
            }
            R.id.btnShowDefault -> {
                val defaultPrefs = defaultPreference(this)
                inUserId.setText(defaultPrefs.userId.toString())
                inPassword.setText(defaultPrefs.password)
            }
        }
    }
}

object PreferenceHelper {
    val USER_ID = "USER_ID"
    val USER_PASSWORD = "PASSWORD"

    fun defaultPreference(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun customPreference(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.userId
        get() = getInt(USER_ID, 0)
        set(value) {
            editMe {
                it.putInt(USER_ID, value)
            }
        }

    var SharedPreferences.password
        get() = getString(USER_PASSWORD, "")
        set(value) {
            editMe {
                it.putString(USER_PASSWORD, value)
            }
        }

    var SharedPreferences.clearValues
        get() = { }
        set(value) {
            editMe {
                it.clear()
            }
        }
}