package sitis.org.climaapp.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import sitis.org.climaapp.R
import sitis.org.climaapp.ui.adapters.ClimaAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_content_container.adapter = ClimaAdapter(supportFragmentManager)
        tabs.setupWithViewPager(tab_content_container)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = injector
}
