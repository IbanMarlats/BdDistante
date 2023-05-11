<?php
include ("connexion.php");

try{
    $cnx=connexionPDO();
    $req = "select * from visiteur";
    $reqPrepa = $cnx->prepare($req);
    $reqPrepa->execute();

    while ($ligne=$reqPrepa->fetch(PDO::FETCH_ASSOC)) {
        $res[]=$ligne;
    }
    print(json_encode($res));
}catch (PDOExeption $e){
    print "erreur !: ".$e->getMessage();
    die();
}

        

?>