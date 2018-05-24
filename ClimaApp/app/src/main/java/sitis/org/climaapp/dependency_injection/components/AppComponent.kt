package sitis.org.climaapp.dependency_injection.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import sitis.org.climaapp.App
import sitis.org.climaapp.dependency_injection.modules.ApiModule
import sitis.org.climaapp.dependency_injection.modules.AppModule
import sitis.org.climaapp.dependency_injection.modules.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    ApiModule::class,
    ActivityComponents::class,
    AndroidInjectionModule::class,
    ViewModelModule::class])
interface AppComponent{
    fun inject(app:App)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app: App): AppComponent.Builder

        fun build(): AppComponent
    }
}