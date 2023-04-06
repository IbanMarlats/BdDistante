package com.example.bddistante.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.bddistante.R;
import com.example.bddistante.modele.VisiteurDAO;

public class MainActivity extends AppCompatActivity {

    private Button btnValider, connect;
    private EditText editMdp,editlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMdp=findViewById(R.id.editMdp);
        btnValider=findViewById(R.id.valider);
        connect=findViewById(R.id.connect);
        editlogin=findViewById(R.id.editlogin);
        btnValider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PropositionActivity.class);
                startActivity(intent);
            }
        });
        connect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String login=editlogin.getText().toString();
                String mdp=editMdp.getText().toString();
                VisiteurDAO visiteurAcces = new VisiteurDAO();
                visiteurAcces.seConnecter(login,mdp);
                Intent intent = new Intent(v.getContext(), PropositionActivity.class);
                startActivity(intent);


            }
        });
    }

}