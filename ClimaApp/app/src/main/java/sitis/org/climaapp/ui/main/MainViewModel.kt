package sitis.org.climaapp.ui.main

import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import sitis.org.climaapp.data.http.ClimaApi
import sitis.org.climaapp.data.models.Clima
import sitis.org.climaapp.util.applySchedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val api: ClimaApi):ViewModel(){
    fun getClima(city: String) : Single<Clima> = api.getClima("select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22$city%2C%20co%22)", "json" ,"store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
            .map { it.result.channel }
            .map { Clima(it.item.condition.temperature, it.item.condition.text, it.atmosphere.humidity, it.atmosphere.pressure) }
            .applySchedulers()
}

