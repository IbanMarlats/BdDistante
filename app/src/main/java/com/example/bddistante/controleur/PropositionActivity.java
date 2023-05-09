package com.example.bddistante.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bddistante.R;

public class PropositionActivity extends AppCompatActivity {

    Button btnAjouter,btnConsulter, btnModif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);
        btnAjouter=findViewById(R.id.ajouter);
        btnConsulter=findViewById(R.id.consulter);
        btnModif=findViewById(R.id.modifier);
        btnAjouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AjoutActivity.class);
                startActivity(intent);
            }
        });
        btnConsulter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);
                startActivity(intent);
            }
        });
        btnModif.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ModifierActivity.class);
                startActivity(intent);
            }
        });
    }
}