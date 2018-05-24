package sitis.org.sitismvvmexample.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import sitis.org.sitismvvmexample.R
import sitis.org.sitismvvmexample.databinding.ActivityLoginBinding
import sitis.org.sitismvvmexample.ui.dashboard.DashboardActivity
import sitis.org.sitismvvmexample.util.LifeDisposable
import sitis.org.sitismvvmexample.util.getViewModel
import sitis.org.sitismvvmexample.util.validateForm
import java.util.prefs.AbstractPreferences

class LoginActivity : AppCompatActivity() {

    private val viewModel : LoginViewModel by lazy {getViewModel<LoginViewModel>()}
    val dis: LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(viewModel.isLogged()){
            startActivity<DashboardActivity>()
            finish()
            return
        }
        setContentView(R.layout.activity_login)

    }

    override fun onResume() {
        super.onResume()
        dis.addDisposable(ingresar_button.clicks()
                .flatMap { validateForm(this, "Por favor, diligencie todos los campos",
                        username.text.toString(), password.text.toString())}
                .subscribe{
                    viewModel.login(username.text.toString(), password.text.toString())
                    startActivity<DashboardActivity>()
                    finish()
                })
    }

}
