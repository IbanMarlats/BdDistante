package com.example.bddistante.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.bddistante.R;
import com.example.bddistante.modele.Visiteur;
import com.example.bddistante.modele.VisiteurDAO;

import org.json.JSONException;

public class ConsultActivity extends AppCompatActivity {
    private ListView listVisiteur;
    private ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
    private Button retour;
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
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consult);
        listVisiteur=(ListView)findViewById(R.id.list);
        VisiteurDAO visiteurAcces = new VisiteurDAO();
        try{
            lesVisiteurs=visiteurAcces.getVisiteurs();
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        ArrayAdapter monAdapter = new ArrayAdapter(ConsultActivity.this,android.R.layout.simple_list_item_1,lesVisiteurs);
        listVisiteur.setAdapter(monAdapter);
        retour=findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PropositionActivity.class);
                startActivity(intent);
            }
        });
        listVisiteur.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Visiteur selectedItem= (Visiteur) listVisiteur.getAdapter().getItem(position);
                Intent i = new Intent(ConsultActivity.this,DetailsActivity.class);
                i.putExtra("id", selectedItem.getId());
                i.putExtra("nom",selectedItem.getNom());
                i.putExtra("prenom",selectedItem.getPrenom());
                i.putExtra("login",selectedItem.getLogin());
                i.putExtra("mdp",selectedItem.getMdp());
                i.putExtra("adresse",selectedItem.getAdresse());
                i.putExtra("cp",selectedItem.getCp());
                i.putExtra("ville",selectedItem.getVille());
                i.putExtra("dateEmbauche",selectedItem.getDateEmbauche());
                startActivity(i);
            }
        });
        int pos=getIntent().getIntExtra("pos", -1);
        if(pos>=0){
            idrecu=getIntent().getStringExtra("id");
            nomrecu=getIntent().getStringExtra("nom");
            prenomrecu=getIntent().getStringExtra("prenom");
            loginrecu=getIntent().getStringExtra("login");
            mdprecu=getIntent().getStringExtra("mdp");
            adresserecu=getIntent().getStringExtra("adresse");
            cprecu=getIntent().getStringExtra("cp");
            villerecu=getIntent().getStringExtra("ville");
            dateEmbaucherecu=getIntent().getStringExtra("dateEmbauche");
        }
    }
}