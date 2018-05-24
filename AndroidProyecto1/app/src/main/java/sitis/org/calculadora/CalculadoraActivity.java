package sitis.org.calculadora;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String DEVELOPER_TAG = "development_tag";
    EditText num1, num2;
    Button btnSuma, btnResta, btnMult, btnDiv;
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(DEVELOPER_TAG, "Entra a On Create");
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.main_activity_number1_edit_text);
        num2 = findViewById(R.id.main_activity_number2_edit_text);
        btnSuma = findViewById(R.id.main_activity_button_sum);
        btnResta = findViewById(R.id.main_activity_button_res);
        btnMult = findViewById(R.id.main_activity_button_mult);
        btnDiv = findViewById(R.id.main_activity_button_div);
        btnSuma.setOnClickListener(this);
        result = findViewById(R.id.main_activity_result);
    }

    @Override
    public void onClick(View v) {
        double value1 = Double.parseDouble(num1.getText().toString());
        double value2 = Double.parseDouble(num2.getText().toString());
        double result = 0;
        switch (v.getId())
        {
            case R.id.main_activity_button_sum:
                result = value1+value2;
                break;
            case R.id.main_activity_button_res:
                result = value1-value2;
                break;
            case R.id.main_activity_button_mult:
                result = value1*value2;
                break;
            case R.id.main_activity_button_div:
                result = value1/value2;
                break;
            default:
                break;
        }
        this.result.setText(""+result);

    }
}
