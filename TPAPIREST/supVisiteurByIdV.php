<?php
include("connexion.php");

$idVisiteur = $_POST['id'];

try{
    $cnx=connexionPDO();
    
    $req = "delete from visiteur WHERE id = :idVisiteur";
    $stm=$cnx->prepare($req);
    $stm->bindParam(':idVisiteur', $idVisiteur);
    $res=$stm->execute();
    
    print(json_encode($res));
    
}catch (PDOExeption $e){
    print "erreur !: ".$e->getMessage();
    die();
}

        

?>