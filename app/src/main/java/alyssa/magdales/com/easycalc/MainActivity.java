package alyssa.magdales.com.easycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtNum1, txtNum2;
    private TextView txtResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnClear, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        btnAdd = (Button)findViewById(R.id.plus);
        btnSubtract = (Button)findViewById(R.id.minus);
        btnMultiply = (Button)findViewById(R.id.times);
        btnDivide = (Button)findViewById(R.id.divide);
        btnClear = (Button)findViewById(R.id.clear);
        btnExit = (Button)findViewById(R.id.exit);

        txtNum1 = (EditText)findViewById(R.id.number1);
        txtNum2 = (EditText)findViewById(R.id.number2);
        txtResult = (TextView)findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String num1 = txtNum1.getText().toString();
        String num2 = txtNum2.getText().toString();

        switch(v.getId()){
            case R.id.plus:
                double addition = Double.parseDouble(num1) + Double.parseDouble(num2);
                txtResult.setText(String.valueOf(addition));
                break;
            case R.id.minus:
                double subtraction = Double.parseDouble(num1) - Double.parseDouble(num2);
                txtResult.setText(String.valueOf(subtraction));
                break;
            case R.id.divide:
                try{
                    double division = Double.parseDouble(num1) / Double.parseDouble(num2);
                    txtResult.setText(String.valueOf(division));
                }catch(Exception e){
                    txtResult.setText("Cannot Divide");
                }
                break;
            case R.id.times:
                double multiply = Double.parseDouble(num1) * Double.parseDouble(num2);
                txtResult.setText(String.valueOf(multiply));
                break;
            case R.id.clear:
                txtNum1.setHint(R.string.edit_text_1);
                txtNum2.setHint(R.string.edit_text_2);
                txtResult.setText(R.string.txtResult);
                break;
            case R.id.exit:
                finish();
                break;
        }
    }
}
