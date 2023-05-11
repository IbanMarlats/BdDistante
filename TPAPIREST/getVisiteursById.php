<?php
include ("connexion.php");
$id=$_POST['id'];
try{
    $cnx=connexionPDO();
    
    $req = "select * from visiteur WHERE id= :id";
    $stm=$cnx->prepare($req);
    $stm->bindParam(':id', $id);
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