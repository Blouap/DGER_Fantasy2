package com.example.projet_version1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChoixPersonnage extends AppCompatActivity {

    private TextView Guerrier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_personnage);

        this.Guerrier=(TextView)findViewById(R.id.Guerrier);

        Guerrier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i2=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i2);
                finish();
            }

        });
    }
}