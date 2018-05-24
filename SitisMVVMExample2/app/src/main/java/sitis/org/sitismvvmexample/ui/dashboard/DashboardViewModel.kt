package sitis.org.sitismvvmexample.ui.dashboard

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Observable
import sitis.org.sitismvvmexample.data.db.AppDatabaseConnection
import sitis.org.sitismvvmexample.data.db.SeguroDao
import sitis.org.sitismvvmexample.data.models.Seguro
import sitis.org.sitismvvmexample.util.applySchedulers
import kotlin.concurrent.thread

class DashboardViewModel: ViewModel(){
    val dao:SeguroDao = AppDatabaseConnection.db.seguroDao()
    fun listSeguro(): Flowable<List<Seguro>> = dao.list().applySchedulers()

    fun delete(seguro:Seguro) : Observable<Seguro> = Observable.fromCallable {
        dao.delete(seguro)
        seguro
    }.applySchedulers()

    fun restore(seguro:Seguro) : Observable<Unit> = Observable.fromCallable {
        dao.insert(seguro)
    }.applySchedulers()
}