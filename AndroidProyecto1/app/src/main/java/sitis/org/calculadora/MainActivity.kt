package sitis.org.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var LAST_OPERATION_RESULT:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_activity_button_sum.setOnClickListener(this::operar)
        main_activity_button_res.setOnClickListener(this::operar)
        main_activity_button_mult.setOnClickListener(this::operar)
        main_activity_button_div.setOnClickListener(this::operar)

        LAST_OPERATION_RESULT = savedInstanceState?.getDouble("LAST_RESULT") ?: 0.0

        main_activity_result.text = "$LAST_OPERATION_RESULT"
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putDouble("LAST_RESULT", LAST_OPERATION_RESULT)
        super.onSaveInstanceState(outState)
    }

    fun operar(view: View){
        val n1 = main_activity_number1_edit_text.text.toString().toDouble()
        val n2 = main_activity_number2_edit_text.text.toString().toDouble()
        val result = when(view.id)
        {
            R.id.main_activity_button_sum -> n1+n2
            R.id.main_activity_button_res -> n1-n2
            R.id.main_activity_button_mult -> n1-n2
            else -> n1/n2;
        }

        this.LAST_OPERATION_RESULT = result;
        main_activity_result.text = "$result"
    }
}
