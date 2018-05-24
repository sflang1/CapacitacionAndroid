package sitis.org.sitismvvmexample.data.preferences

import android.content.Context
import android.content.SharedPreferences

object UserSession{
    private lateinit var preferences: SharedPreferences

    var username : String
    get() = preferences.getString("username", null)

    set(value) { preferences.edit().putString("username", value).apply() }

    var password : String
    get() = preferences.getString("password", null)
    set(value) {
        preferences.edit().putString("password", value).apply()
    }

    var logged : Boolean
        get() =  preferences.getBoolean("logged", false)
        set(value) {
            preferences.edit().putBoolean("logged", value).apply()
        }

    fun init(context: Context){
        preferences = context.getSharedPreferences("Seguros", Context.MODE_PRIVATE)
    }
}