package sitis.org.climaapp.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class AppViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    :ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: throw Throwable("Unknown model: $modelClass")
        return creator.get() as T
    }
}

inline fun <reified T: ViewModel> AppCompatActivity.buildViewModel(factory: ViewModelProvider.Factory):T =
        ViewModelProviders.of(this, factory).get(T::class.java)

inline fun <reified T: ViewModel> Fragment.buildViewModel(factory: ViewModelProvider.Factory):T =
        ViewModelProviders.of(this, factory).get(T::class.java)