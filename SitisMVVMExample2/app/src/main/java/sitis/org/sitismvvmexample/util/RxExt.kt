package sitis.org.sitismvvmexample.util

import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.toast

fun validateForm(context: Context, msg: String, vararg args: String):Observable<List<String>> = Observable.create {
    if(args.contains("")) context.toast(msg)
    else it.onNext(args.toList())
    it.onComplete()
}

fun <T>Observable<T>.applySchedulers(): Observable<T> = compose{
    it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T>Single<T>.applySchedulers(): Single<T> = compose{
    it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T>Maybe<T>.applySchedulers(): Maybe<T> = compose{
    it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T>Flowable<T>.applySchedulers(): Flowable<T> = compose{
    it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T>showSnackbar(view: View, msg: String, actionText : String, data: T) : Observable<T> = Observable.create {emitter->
    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
            .setAction(actionText) {
                emitter.onNext(data)
                emitter.onComplete()
            }.show()

}