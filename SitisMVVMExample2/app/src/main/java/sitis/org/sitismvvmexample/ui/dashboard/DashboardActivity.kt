package sitis.org.sitismvvmexample.ui.dashboard

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import sitis.org.sitismvvmexample.R
import sitis.org.sitismvvmexample.data.models.Seguro
import sitis.org.sitismvvmexample.ui.adapters.SeguroAdapter
import sitis.org.sitismvvmexample.ui.add.AddActivity
import sitis.org.sitismvvmexample.util.LifeDisposable
import sitis.org.sitismvvmexample.util.getViewModel
import sitis.org.sitismvvmexample.util.showSnackbar

class DashboardActivity : AppCompatActivity() {

    val viewModel : DashboardViewModel by lazy { getViewModel<DashboardViewModel>() }
    val adapter:SeguroAdapter = SeguroAdapter()
    val disposable : LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        list_container.adapter = adapter
        list_container.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener{
            startActivity<AddActivity>()
        }
    }

    override fun onResume() {
        super.onResume()
        disposable.addDisposable(viewModel.listSeguro().subscribe({
            adapter.data = it
        }))
        disposable.addDisposable(
                adapter.onRemoveObserver
                        .flatMap { viewModel.delete(it) }
                        .flatMap { showSnackbar(contentView!!,"Seguro eliminado", "Deshacer", it) }
                        .flatMap { viewModel.restore(it) }
                        .subscribe()
        )
    }
}
