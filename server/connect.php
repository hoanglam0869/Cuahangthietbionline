<?php
    $host = "localhost";
    $username = "id15271342_lam1";
    $password = "-Lam-280693-";
    $database = "id15271342_sp";

    $conn = mysqli_connect($host, $username, $password, $database);
    mysqli_query($conn, "SET NAMES 'utf8'");

    /*if($conn){
        echo "Kết nối thành công";   
    }else{
        echo "Kết nối thất bại";
    }*/
?>