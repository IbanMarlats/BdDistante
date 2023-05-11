<?php
    function connexionPDO(){
        $login="iban336";
        $mdp="Im23093128*";
        $bd="iban336_visiteurs";
        $server="mysql-iban336.alwaysdata.net";
        try{
            $conn=new PDO("mysql:host=$server;dbname=$bd",$login,$mdp);
            return $conn;
        }catch(PDOExeption $e){
            print "connexion à la base de données impossible";
            die();
        }
    }
?>