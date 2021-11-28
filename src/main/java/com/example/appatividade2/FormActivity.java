package com.example.appatividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    public static int RESULT_CANCEL = 0;
    public static int RESULT_ADD = 1;
    EditText edtName;
    EditText edtTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtName = findViewById(R.id.editTextName);
        edtTeam = findViewById(R.id.editTextTeam);
    }


    public void save(View view){

        Intent intent = new Intent();

        String name = edtName.getText().toString();
        String team = edtTeam.getText().toString();
        intent.putExtra("name", name );
        intent.putExtra("team", team);
        setResult(RESULT_ADD, intent);
        finish();
    }

    public void cancel(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCEL, intent);
        finish();
    }



}