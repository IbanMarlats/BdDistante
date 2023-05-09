package com.example.bddistante.modele;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class VisiteurDAO {

    public VisiteurDAO() {
    }


    public String addVisiteur(Visiteur unVisiteur) {
        String result = "";
        //adresse de l'URL de l\'API à interroger et fichier php permettant d'\ajouter le visiteur
        String myUrl="https://iban336.alwaysdata.net/API/addVisiteur.php";
        //informations à transmettre pour effectuer l'ajout
        String params =
                "id="+unVisiteur.getId()+"&nom="+unVisiteur.getNom()+
                "&prenom="+unVisiteur.getPrenom()+
                "&login="+unVisiteur.getLogin()+
                "&mdp="+unVisiteur.getMdp()+
                "&adresse="+unVisiteur.getAdresse()+
                "&cp="+unVisiteur.getCp()+
                "&ville="+unVisiteur.getVille()+
                "&dateEmbauche="+unVisiteur.getDateEmbauche() ;
        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat",result);
        return result;
    }

    public ArrayList<Visiteur> getVisiteurs() throws JSONException{

        String result = "";
        String myUrl="https://iban336.alwaysdata.net/API/getVisiteurs.php";
        String params = "";
        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<Visiteur> visiteurs = new ArrayList<Visiteur>();
        JSONArray array = new JSONArray(result);
        for (int i=0; i<array.length();i++){
            String id=array.getJSONObject(i).getString("id");
            String nom=array.getJSONObject(i).getString("nom");
            String prenom=array.getJSONObject(i).getString("prenom");
            String login=array.getJSONObject(i).getString("login");
            String mdp=array.getJSONObject(i).getString("mdp");
            String adresse=array.getJSONObject(i).getString("adresse");
            String cp=array.getJSONObject(i).getString("cp");
            String ville=array.getJSONObject(i).getString("ville");
            String dateEmbauche=array.getJSONObject(i).getString("dateEmbauche");
            visiteurs.add(new Visiteur(id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche));
        }
        return visiteurs;
    }

    public String modifierVisiteur(Visiteur unVisiteur,String resId) {
        String result = "";
        String myUrl="https://iban336.alwaysdata.net/API/modifVisiteurByIdV.php";
        String params =
                        "id="+unVisiteur.getId()+"&nom="+unVisiteur.getNom()+
                        "&prenom="+unVisiteur.getPrenom()+
                        "&login="+unVisiteur.getLogin()+
                        "&mdp="+unVisiteur.getMdp()+
                        "&adresse="+unVisiteur.getAdresse()+
                        "&cp="+unVisiteur.getCp()+
                        "&ville="+unVisiteur.getVille()+
                        "&dateEmbauche="+unVisiteur.getDateEmbauche() ;

                Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
    public String supprimerVisiteur(Visiteur unVisiteur) {
        String result = "";
        String myUrl="https://iban336.alwaysdata.net/API/supVisiteurByIdV.php";
        String params ="id="+unVisiteur.getId();

        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Boolean seConnecter(String unLogin, String unMdp)
    {
        String result = "";
        String myUrl="https://iban336.alwaysdata.net/API/supVisiteurByIdV.php";
        String params ="";
        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<Visiteur> list;
        try{
            list=this.getVisiteurs();
            for (Visiteur unVisiteur:list) {
                try{
                    if (unVisiteur.getLogin().equals(unLogin) && unVisiteur.getMdp().equals(unMdp)) {
                        return true;
                    }
                }catch(Exception e){
                    throw new Error("error 400");
                }
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return null ;
    }
}

