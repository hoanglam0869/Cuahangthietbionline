<?php
    include "connect.php";
    $query = "SELECT * FROM loaisanpham";
    $data = mysqli_query($conn, $query);
    $mangloaisp = array();
    while ($row = mysqli_fetch_assoc($data)) {
        /*array_push($mangloaisp, new Loaisp(
            $row['id'],
            $row['tenloaisanpham'],
            $row['hinhanhloaisanpham']));*/
        array_push($mangloaisp, ["id" => $row['id'], "tenloaisp" => $row['tenloaisanpham'], "hinhanhloaisp" => $row['hinhanhloaisanpham']]);
    }
    echo json_encode($mangloaisp);
    /*class Loaisp {
        function __function($id, $tenloaisp, $hinhanhloaisp) {
            $this->id = $id;
            $this->tenloaisp = $tenloaisp;
            $this->hinhanhloaisp = $hinhanhloaisp;
        }
    }*/
?>