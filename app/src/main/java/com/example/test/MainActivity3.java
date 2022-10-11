package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public EditText editTextNumberDecimal6,editTextNumberDecimal7,editTextNumberDecimal8,editTextNumberDecimal9;
    public Button convert;
    public TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void returnBack(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void convert(View v ){
        editTextNumberDecimal6 = (EditText) findViewById(R.id.editTextNumberDecimal6);
        editTextNumberDecimal7 = (EditText) findViewById(R.id.editTextNumberDecimal7);
        editTextNumberDecimal8 = (EditText) findViewById(R.id.editTextNumberDecimal8);
        editTextNumberDecimal9 = (EditText) findViewById(R.id.editTextNumberDecimal9);
        editTextNumberDecimal9 = (EditText) findViewById(R.id.editTextNumberDecimal9);
        textView4 = (TextView) findViewById(R.id.textView4);

        String ip1,ip2,ip3,ip4;
        ip1 = String.valueOf(editTextNumberDecimal6.getText());
        ip2 = String.valueOf(editTextNumberDecimal7.getText());
        ip3 = String.valueOf(editTextNumberDecimal8.getText());
        ip4 = String.valueOf(editTextNumberDecimal9.getText());
        closeKeyboard();

        textView4.setText(String.format("%8s", Integer.toBinaryString(Integer.parseInt(ip1))).replace(' ', '0')+"."+String.format("%8s", Integer.toBinaryString(Integer.parseInt(ip2))).replace(' ', '0')+"."+String.format("%8s", Integer.toBinaryString(Integer.parseInt(ip3))).replace(' ', '0')+"."+String.format("%8s", Integer.toBinaryString(Integer.parseInt(ip4))).replace(' ', '0'));
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("IPV4", String.valueOf(textView4.getText()));
        clipboard.setPrimaryClip(clip);

    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}