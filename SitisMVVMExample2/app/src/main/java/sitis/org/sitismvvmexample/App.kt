package sitis.org.sitismvvmexample

import android.app.Application
import sitis.org.sitismvvmexample.data.db.AppDatabaseConnection
import sitis.org.sitismvvmexample.data.preferences.UserSession

class App:Application(){
    override fun onCreate() {
        super.onCreate()
        UserSession.init(this)
        AppDatabaseConnection.init(this)
    }
}