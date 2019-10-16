package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick (View v){
        EditText el1=(EditText)findViewById(R.id.Num1);
        EditText el2=(EditText)findViewById(R.id.Num2);
        TextView resText =(TextView) findViewById(R.id.Res);
        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int reaSum=0;
        switch (v.getId()) {
            case R.id.Sum: reaSum =num1+num2;break;
            case R.id.Minus: reaSum =num1-num2;break;
            case R.id.Mul: reaSum =num1*num2;break;
            case R.id.Del: reaSum =num1/num2;break;
        }
        resText.setText(Integer.toString(reaSum));
    }
}