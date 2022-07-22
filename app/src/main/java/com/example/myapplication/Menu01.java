package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Menu01 extends AppCompatActivity {

    //String usuario = getIntent().getStringExtra("extra");
    operaciones ope = new operaciones();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu01);

        TextView textView = findViewById(R.id.txt_name);
        Intent intent = getIntent();
        String nomina = intent.getStringExtra("extra");
        if(nomina != null){
            String userName = ope.getUsarName(nomina).toString();
            textView.setText(userName);
        }

        }




}