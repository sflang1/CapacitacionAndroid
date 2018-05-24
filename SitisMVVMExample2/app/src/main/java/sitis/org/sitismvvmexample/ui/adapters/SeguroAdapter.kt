package sitis.org.sitismvvmexample.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject
import sitis.org.sitismvvmexample.R
import sitis.org.sitismvvmexample.data.models.Seguro
import sitis.org.sitismvvmexample.databinding.TemplateSeguroBinding

class SeguroAdapter:RecyclerView.Adapter<SeguroViewHolder>(){
    val onRemoveObserver : PublishSubject<Seguro> = PublishSubject.create()

    var data : List<Seguro> = emptyList()
    set(value)
    {
        notifyDataSetChanged()
        field = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeguroViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_seguro, parent, false)
        return SeguroViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SeguroViewHolder, position: Int) = holder.bind(data[position], position, onRemoveObserver)
}

class SeguroViewHolder(view:View): RecyclerView.ViewHolder(view){
    val binding = TemplateSeguroBinding.bind(view)

    fun bind(seguro: Seguro, position: Int, onRemoveObserver : PublishSubject<Seguro>){
        binding.seguro = seguro
        binding.onRemove = onRemoveObserver
    }
}