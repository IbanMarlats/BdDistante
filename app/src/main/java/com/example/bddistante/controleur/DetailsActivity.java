package com.example.bddistante.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bddistante.R;
import com.example.bddistante.modele.Visiteur;
import com.example.bddistante.modele.VisiteurDAO;

import org.json.JSONException;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private EditText id, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche;
    private Button retour;
    private Button valider, supprimer;
    private String idrecu;
    private String nomrecu;
    private String prenomrecu;
    private String loginrecu;
    private String mdprecu;
    private String adresserecu;
    private String cprecu;
    private String villerecu;
    private String dateEmbaucherecu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        retour=findViewById(R.id.retour2);
        valider=findViewById(R.id.buttonValider);
        supprimer=findViewById(R.id.buttonSupprimer);
        retour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);
                startActivity(intent);
            }
        });

        idrecu=getIntent().getStringExtra("id");
        nomrecu=getIntent().getStringExtra("nom");
        prenomrecu=getIntent().getStringExtra("prenom");
        loginrecu=getIntent().getStringExtra("login");
        mdprecu=getIntent().getStringExtra("mdp");
        adresserecu=getIntent().getStringExtra("adresse");
        cprecu=getIntent().getStringExtra("cp");
        villerecu=getIntent().getStringExtra("ville");
        dateEmbaucherecu=getIntent().getStringExtra("dateEmbauche");

        id=(EditText)findViewById(R.id.editTextId);
        nom=(EditText)findViewById(R.id.editTextNom);
        prenom=(EditText)findViewById(R.id.editTextPre);
        login=(EditText)findViewById(R.id.editTextLogin);
        mdp=(EditText)findViewById(R.id.editTextMdp);
        adresse=(EditText)findViewById(R.id.editTextAdRue);
        cp=(EditText)findViewById(R.id.editTextCP);
        ville=(EditText)findViewById(R.id.editTextVille);
        dateEmbauche=(EditText)findViewById(R.id.editTextDate);

        id.setText(idrecu);
        nom.setText(nomrecu);
        prenom.setText(prenomrecu);
        login.setText(loginrecu);
        mdp.setText(mdprecu);
        adresse.setText(adresserecu);
        cp.setText(cprecu);
        ville.setText(villerecu);
        dateEmbauche.setText(dateEmbaucherecu);


        valider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);
                startActivity(intent);
            }
        });
        supprimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                delete();
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);
                startActivity(intent);
            }
        });
    }
    private void update(){
        VisiteurDAO visiteurAcces = new VisiteurDAO();
        ArrayList<Visiteur> listeVisiteur;
        /*try{
            listeVisiteur=visiteurAcces.getVisiteurs();
        }
        catch (JSONException e){
            e.printStackTrace();
        }*/
        Visiteur unVisiteur= new Visiteur(id.getText().toString(), nom.getText().toString(), prenom.getText().toString(), login.getText().toString(), mdp.getText().toString(), adresse.getText().toString(),
                cp.getText().toString(), ville.getText().toString(), dateEmbauche.getText().toString());
        String id=idrecu;
        visiteurAcces.modifierVisiteur(unVisiteur, id);
    }
    private void delete(){
        VisiteurDAO visiteurAcces = new VisiteurDAO();
        ArrayList<Visiteur> listVisiteur;
        try{
            listVisiteur=visiteurAcces.getVisiteurs();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        Visiteur unVisiteur= new Visiteur(id.getText().toString(), nom.getText().toString(), prenom.getText().toString(), login.getText().toString(), mdp.getText().toString(), adresse.getText().toString(),
                cp.getText().toString(), ville.getText().toString(), dateEmbauche.getText().toString());
        visiteurAcces.supprimerVisiteur(unVisiteur);
    }
}