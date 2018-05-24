package sitis.org.sitismvvmexample.util

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class LifeDisposable(owner: LifecycleOwner): LifecycleObserver {
    private val dis : CompositeDisposable = CompositeDisposable()

    init{
        owner.lifecycle.addObserver(this)
    }

    fun addDisposable(dis: Disposable){
        this.dis.add(dis)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun clear(){
        dis.clear()
    }
}