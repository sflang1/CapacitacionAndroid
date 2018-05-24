package sitis.org.sitismvvmexample.ui.add

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.template_seguro.*
import org.jetbrains.anko.toast
import sitis.org.sitismvvmexample.R
import sitis.org.sitismvvmexample.util.LifeDisposable
import sitis.org.sitismvvmexample.util.getViewModel
import sitis.org.sitismvvmexample.util.validateForm
import java.util.*

class AddActivity : AppCompatActivity() {

    val viewModel:AddViewModel by lazy { getViewModel<AddViewModel>() }
    val disposable : LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btn_cancelar.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        disposable.addDisposable(btn_aceptar.clicks()
                .flatMap { validateForm(this, "Por favor, diligencie todos los campos",
                        nombre_aseguradora.text.toString(), nombre_beneficiario.text.toString()) }
                .flatMap {
                    viewModel.saveSeguro(it[0], it[1], Date())
                }.subscribe({
                    toast("Seguro insertado")
                    finish()
                }))
    }
}
