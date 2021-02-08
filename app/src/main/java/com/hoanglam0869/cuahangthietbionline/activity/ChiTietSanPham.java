package com.hoanglam0869.cuahangthietbionline.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.hoanglam0869.cuahangthietbionline.R;
import com.hoanglam0869.cuahangthietbionline.model.Giohang;
import com.hoanglam0869.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChiTietSanPham extends AppCompatActivity {

    Toolbar toolbarChiTiet;
    ImageView imgChiTiet;
    TextView txtTen, txtGia, txtMoTa;
    Spinner spinner;
    Button btnDatMua;
    int id = 0;
    String TenChitiet = "";
    int GiaChitiet = 0;
    String HinhanhChitiet = "";
    String MotaChitiet = "";
    int Idsanpham = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        
        AnhXa();
        ActionToolbar();
        GetInformation();
        CatchEventSpinner();
        EventButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuGioHang:
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void EventButton() {
        btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGiohang.size() > 0) {
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists = false;
                    for (int i = 0; i < MainActivity.mangGiohang.size(); i++) {
                        if (MainActivity.mangGiohang.get(i).getIdsp() == id) {
                            MainActivity.mangGiohang.get(i).setSoluongsp(MainActivity.mangGiohang.get(i).getSoluongsp() + sl);
                            if (MainActivity.mangGiohang.get(i).getSoluongsp() >= 10) {
                                MainActivity.mangGiohang.get(i).setSoluongsp(10);
                            }
                            MainActivity.mangGiohang.get(i).setGiasp(GiaChitiet * MainActivity.mangGiohang.get(i).getSoluongsp());
                            exists = true;
                        }
                    }
                    if (exists == false) {
                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        long Giamoi = soluong * GiaChitiet;
                        MainActivity.mangGiohang.add(new Giohang(id, TenChitiet, Giamoi, HinhanhChitiet, soluong));
                    }
                } else {
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long Giamoi = soluong * GiaChitiet;
                    MainActivity.mangGiohang.add(new Giohang(id, TenChitiet, Giamoi, HinhanhChitiet, soluong));
                }
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEventSpinner() {
        Integer[] soluong = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation() {
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id = sanpham.getID();
        TenChitiet = sanpham.getTensanpham();
        GiaChitiet = sanpham.getGiasanpham();
        HinhanhChitiet = sanpham.getHinhanhsanpham();
        MotaChitiet = sanpham.getMotasanpham();
        Idsanpham = sanpham.getIDSanpham();
        txtTen.setText(TenChitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGia.setText("Giá: " + decimalFormat.format(GiaChitiet) + " Đ");
        txtMoTa.setText(MotaChitiet);
        Picasso.get().load(HinhanhChitiet)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imgChiTiet);
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbarChiTiet = findViewById(R.id.toolBarChiTietSanPham);
        imgChiTiet = findViewById(R.id.imageViewChiTietSanPham);
        txtTen = findViewById(R.id.textViewTenChiTietSanPham);
        txtGia = findViewById(R.id.textViewGiaChiTietSanPham);
        txtMoTa = findViewById(R.id.textViewMoTaChiTietSanPham);
        spinner = findViewById(R.id.spinner);
        btnDatMua = findViewById(R.id.buttonDatMua);
    }
}