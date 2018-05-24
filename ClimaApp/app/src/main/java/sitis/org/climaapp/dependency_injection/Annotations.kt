package sitis.org.climaapp.dependency_injection

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Scope
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val key: KClass<out ViewModel>)

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope