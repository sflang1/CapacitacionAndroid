package sitis.org.climaapp.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.rxkotlin.subscribeBy
import sitis.org.climaapp.data.models.Clima

import sitis.org.climaapp.databinding.FragmentCityBinding
import sitis.org.climaapp.dependency_injection.Injectable
import sitis.org.climaapp.ui.main.MainViewModel
import sitis.org.climaapp.util.AppViewModelFactory
import sitis.org.climaapp.util.LifeDisposable
import sitis.org.climaapp.util.buildViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CityFragment : Fragment(), Injectable {

    @Inject
    lateinit var factory:AppViewModelFactory
    val viewModel : MainViewModel by lazy { buildViewModel<MainViewModel>(factory) }
    lateinit var binding : FragmentCityBinding
    val city : String by lazy { arguments!!.getString("city") }

    val dis: LifeDisposable = LifeDisposable(this)

    companion object {
        val CITY_NAMES: List<String> = listOf(
                "Popayán",
                "Cali",
                "Bogotá"
        )

        fun instance(city: String):CityFragment{
            val fragment = CityFragment()
            val args = Bundle()
            args.putString("city", city)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentCityBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dis add viewModel.getClima(city).
                subscribeBy(
                        onSuccess = {

                        },
                        onError = {

                        }
                )
    }


}
