package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public TextView textView3;
    public EditText editTextNumberDecimal,editTextNumberDecimal2;
    public RadioButton radioPlus,radioMinus,radioDel,radioUmn;
    public Button result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    @SuppressLint("SetTextI18n")
    public void showResult(View v) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        try {
            textView3 = findViewById(R.id.textView3);
            editTextNumberDecimal = (EditText) findViewById(R.id.editTextNumberDecimal);
            editTextNumberDecimal2 = (EditText) findViewById(R.id.editTextNumberDecimal2);
            result = findViewById(R.id.result);
            radioPlus = findViewById(R.id.radioPlus);
            radioMinus = findViewById(R.id.radioMinus);
            radioUmn = findViewById(R.id.radioUmn);
            radioDel = findViewById(R.id.radioDel);
            float num1, num2,res;
            String action;
            action = "";

            num1 = Float.parseFloat(String.valueOf(editTextNumberDecimal.getText()));
            num2 = Float.parseFloat(String.valueOf(editTextNumberDecimal2.getText()));

           /*if(!radioMinus.isChecked() || !radioPlus.isChecked() || !radioDel.isChecked() || !radioUmn.isChecked())
            {
                textView3.setText("Выберите действие");
            }*/
            if(radioPlus.isChecked()) {
                res = num1+num2;
                action = "+";
            }
            else if(radioMinus.isChecked())
            {
                res=num1-num2;
                action = "-";
            }
            else if(radioDel.isChecked()) {
                res=num1/num2;
                action = "/";
            }
            else if(radioUmn.isChecked())
            {
                res=(num1*num2);

                action = "*";
            }else res = 0;

            closeKeyboard();
            if(num1 % 1 == 0 && num2 % 1 != 0){
                textView3.setText((String.valueOf(num1).toString().replaceAll("\\.?0*$", ""))+" "+action+" "+String.valueOf(num2)+" = "+String.valueOf(res));

            }
            else if(num2 % 1 == 0 && num1 % 1 != 0 ){
                textView3.setText((String.valueOf(num1))+" "+action+" "+String.valueOf(num2).toString().replaceAll("\\.?0*$", "")+" = "+String.valueOf(res));

            }
            else if(num1 % 1 == 0 && num2 % 1 == 0){
                textView3.setText((String.valueOf(num1).toString().replaceAll("\\.?0*$", ""))+" "+action+" "+String.valueOf(num2).toString().replaceAll("\\.?0*$", "")+" = "+String.valueOf(res).toString().replaceAll("\\.?0*$", ""));

            }
            else if(res % 1 == 0){
                textView3.setText((String.valueOf(num1).toString().replaceAll("\\.?0*$", ""))+" "+action+" "+String.valueOf(num2).toString().replaceAll("\\.?0*$", "")+" = "+String.valueOf(res).toString().replaceAll("\\.?0*$", ""));

            }else

            textView3.setText((String.valueOf(num1)+" "+action+" "+String.valueOf(num2)+" = "+roundAvoid(res,5)));


        }catch (NumberFormatException e) {
            if(String.valueOf(editTextNumberDecimal.getText()) == ""){
                textView3.setText("Введите числа1");
            }else
            textView3.setText("Введите числа");
            closeKeyboard();

        }
        catch (NullPointerException e) {
            textView3.setText("Введите числа");
            closeKeyboard();

        }




    }

    public void clearFields(View view) {
        EditText pole1 = findViewById(R.id.editTextNumberDecimal);
        EditText pole2 = findViewById(R.id.editTextNumberDecimal2);
        pole1.setText(null);
        pole2.setText(null);
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void returnBack(View v){
        onBackPressed();
    }
}