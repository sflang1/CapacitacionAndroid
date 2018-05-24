package sitis.org.climaapp.dependency_injection.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sitis.org.climaapp.dependency_injection.ViewModelKey
import sitis.org.climaapp.ui.main.MainViewModel
import sitis.org.climaapp.util.AppViewModelFactory

@Module
abstract class ViewModelModule{

    @Binds
    abstract fun bindFactory(factory: AppViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindClimaViewModel(climaViewModel: MainViewModel):ViewModel
}