<?php
include ("connexion.php");
$login=$_POST['login'];
$mdp=$_POST['mdp'];
try{
    $cnx=connexionPDO();
    $req = "select * from visiteur WHERE login=:login AND mdp=:mdp";
    $stm=$cnx->prepare($req);
    $stm->bindParam(':login', $login);
    $stm->bindParam(':mdp', $mdp);
    $stm->execute();
    while ($ligne=$stm->fetch(PDO::FETCH_ASSOC)) {
        $res[]=$ligne;
    }
    print(json_encode($res));
}catch (PDOExeption $e){
    print "erreur !: ".$e->getMessage();
    die();
}

        

?>