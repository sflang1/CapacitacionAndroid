package sitis.org.climaapp.dependency_injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sitis.org.climaapp.ui.fragments.CityFragment

@Module
abstract class MainActivityModule{
    @ContributesAndroidInjector()
    abstract fun bindCityFragment():CityFragment
}