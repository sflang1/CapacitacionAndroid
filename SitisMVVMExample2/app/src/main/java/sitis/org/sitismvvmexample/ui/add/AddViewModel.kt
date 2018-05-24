package sitis.org.sitismvvmexample.ui.add

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import sitis.org.sitismvvmexample.App
import sitis.org.sitismvvmexample.data.db.AppDatabaseConnection
import sitis.org.sitismvvmexample.data.models.Seguro
import sitis.org.sitismvvmexample.util.applySchedulers
import java.util.*
import kotlin.concurrent.thread

class AddViewModel: ViewModel(){
    private val db: AppDatabaseConnection = AppDatabaseConnection.db

    fun saveSeguro(aseguradora: String, beneficiario: String, fecha: Date) : Observable<Unit> = Observable.fromCallable{
        db.seguroDao().insert(Seguro(null, aseguradora = aseguradora, beneficiario = beneficiario, fecha = fecha))
    }.applySchedulers()
}