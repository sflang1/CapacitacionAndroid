package sitis.org.sitismvvmexample.ui.login

import android.arch.lifecycle.ViewModel
import sitis.org.sitismvvmexample.data.preferences.UserSession

class LoginViewModel : ViewModel(){
    fun login(username: String, password: String){
        UserSession.username = username
        UserSession.password = password
        UserSession.logged = true
    }

    fun isLogged():Boolean = UserSession.logged
}