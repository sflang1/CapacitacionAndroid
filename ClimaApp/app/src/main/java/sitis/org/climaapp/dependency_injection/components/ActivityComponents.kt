package sitis.org.climaapp.dependency_injection.components

import dagger.Component
import dagger.Module
import dagger.android.ContributesAndroidInjector
import sitis.org.climaapp.dependency_injection.modules.ApiModule
import sitis.org.climaapp.dependency_injection.modules.MainActivityModule
import sitis.org.climaapp.ui.main.MainActivity

@Module
abstract class ActivityComponents{

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity():MainActivity


}