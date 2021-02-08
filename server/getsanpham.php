<?php
    include "connect.php";
    $page = $_GET['page'];
    $idsp = $_POST['idsanpham'];
    $space = 5;
    // 1-5, 6-10
    $limit = ($page - 1) * $space;
    $mangsanpham = array();
    $query = "SELECT * FROM sanpham WHERE idsanpham = $idsp LIMIT $limit, $space";
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)) {
        /*array_push($mangsanpham, new Sanpham(
            $row['id'],
            $row['tensanpham'],
            $row['giasanpham'],
            $row['hinhanhsanpham'],
            $row['motasanpham'],
            $row['idsanpham']
        ));*/
        array_push($mangsanpham, ["id" => $row['id'], "tensp" => $row['tensanpham'], "giasp" => $row['giasanpham'],
        "hinhanhsp" => $row['hinhanhsanpham'], "motasp" => $row['motasanpham'], "idsanpham" => $row['idsanpham']]);
    }
    echo json_encode($mangsanpham);
    /*class Sanpham {
        function Sanpham($id, $tensp, $giasp, $hinhanhsp, $motasp, $idsanpham) {
            $this->id = $id;
            $this->tensp = $tensp;
            $this->giasp = $giasp;
            $this->hinhanhsp = $hinhanhsp;
            $this->motasp = $motasp;
            $this->idsanpham = $idsanpham;
        }
    }*/
?>