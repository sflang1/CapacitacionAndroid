package sitis.org.climaapp.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import sitis.org.climaapp.ui.fragments.CityFragment

class ClimaAdapter(fm: FragmentManager):FragmentPagerAdapter(fm){
    val fragmentList : List<CityFragment> = CityFragment.CITY_NAMES.map {
        CityFragment.instance(it)
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = CityFragment.CITY_NAMES[position]
}