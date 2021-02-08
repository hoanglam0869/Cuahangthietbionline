package com.hoanglam0869.cuahangthietbionline.ultil;

import com.hoanglam0869.cuahangthietbionline.model.Sanpham;

public class Server {
    public static String localhost = "192.168.1.8";
    public static String DuongdanLoaisp = "http://" + localhost + "/server/getloaisp.php";
    public static String Duongdansanphammoinhat = "http://" + localhost + "/server/getsanphammoinhat.php";
    public static String Duongdandienthoai = "http://" + localhost + "/server/getsanpham.php?page=";
    public static String Duongdandonhang = "http://" + localhost + "/server/thongtinkhachhang.php";
    public static String Duongdanchitietdonhang = "http://" + localhost + "/server/chitietdonhang.php";
}
