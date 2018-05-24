package sitis.org.climaapp.dependency_injection.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import sitis.org.climaapp.App
import javax.inject.Singleton

@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext(app: App): Context = app

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context):SharedPreferences = context.getSharedPreferences("ClimaApp", Context.MODE_PRIVATE)
}