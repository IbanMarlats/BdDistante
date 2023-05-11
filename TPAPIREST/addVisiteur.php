<?php
include ("connexion.php");
$id=$_POST['id'];
$nom=$_POST['nom'];
$prenom=$_POST['prenom'];
$login=$_POST['login'];
$mdp=$_POST['mdp'];
$adresse=$_POST['adresse'];
$cp=$_POST['cp'];
$ville=$_POST['ville'];
$dateEmbauche=$_POST['dateEmbauche'];

try{
    $cnx=connexionPDO();
    
    $req = "insert into visiteur values (:id, :nom, :prenom, :login, :mdp, :adresse, :cp, :ville, :dateEmbauche)";
    $stm=$cnx->prepare($req);
    $stm->bindParam(':id', $id);
    $stm->bindParam(':nom', $nom);
    $stm->bindParam(':prenom', $prenom);
    $stm->bindParam(':login', $login);
    $stm->bindParam(':mdp', $mdp);
    $stm->bindParam(':adresse', $adresse);
    $stm->bindParam(':cp', $cp);
    $stm->bindParam(':ville', $ville);
    $stm->bindParam(':dateEmbauche', $dateEmbauche);
    $res=$stm->execute();
    print($res);
}catch (PDOExeption $e){
    print "erreur !: ".$e->getMessage();
    die();
}

        //http://iban336.alwaysdata.net/API/addVisiteur.php?id=a336&nom=marlats&prenom=Iban&login=im385&mdp=root&adresse=RueBordeaux&cp=33000&ville=Bordeaux&dateEmbauche=23/09/2000

?>