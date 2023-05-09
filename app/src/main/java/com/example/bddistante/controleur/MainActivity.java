package com.example.bddistante.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bddistante.R;
import com.example.bddistante.modele.VisiteurDAO;

public class MainActivity extends AppCompatActivity {

    private Button btnValider, connect;
    private EditText editMdp,editlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMdp=findViewById(R.id.mdp);
        connect=findViewById(R.id.connect);
        editlogin=findViewById(R.id.login);

        connect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String login=editlogin.getText().toString();
                String mdp=editMdp.getText().toString();
                VisiteurDAO visiteurAcces = new VisiteurDAO();
                //boolean isConnected = visiteurAcces.seConnecter(login,mdp);
                if (visiteurAcces.seConnecter(login,mdp) == true){
                    Intent intent = new Intent(v.getContext(), PropositionActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Login ou mdp incorrect",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

}