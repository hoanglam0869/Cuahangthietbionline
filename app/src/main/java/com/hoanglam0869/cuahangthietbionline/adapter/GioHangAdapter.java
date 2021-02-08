package com.hoanglam0869.cuahangthietbionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoanglam0869.cuahangthietbionline.R;
import com.hoanglam0869.cuahangthietbionline.activity.GioHangActivity;
import com.hoanglam0869.cuahangthietbionline.activity.MainActivity;
import com.hoanglam0869.cuahangthietbionline.model.Giohang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang> arrayGiohang;

    public GioHangAdapter(Context context, ArrayList<Giohang> arrayGiohang) {
        this.context = context;
        this.arrayGiohang = arrayGiohang;
    }

    @Override
    public int getCount() {
        return arrayGiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayGiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txtTenGioHang, txtGiaGioHang;
        public ImageView imgGioHang;
        public Button btnMinus, btnValues, btnPlus;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_giohang, null);
            viewHolder.txtTenGioHang = convertView.findViewById(R.id.textViewTenGioHang);
            viewHolder.txtGiaGioHang = convertView.findViewById(R.id.textViewGiaGioHang);
            viewHolder.imgGioHang = convertView.findViewById(R.id.imageViewGioHang);
            viewHolder.btnMinus = convertView.findViewById(R.id.buttonMinus);
            viewHolder.btnValues = convertView.findViewById(R.id.buttonValues);
            viewHolder.btnPlus = convertView.findViewById(R.id.buttonPlus);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Giohang giohang = (Giohang) getItem(position);
        viewHolder.txtTenGioHang.setText(giohang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaGioHang.setText("Giá: " + decimalFormat.format(giohang.getGiasp()) + " Đ");
        Picasso.get().load(giohang.getHinhsp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgGioHang);
        viewHolder.btnValues.setText(giohang.getSoluongsp() + "");
        int sl = Integer.parseInt(viewHolder.btnValues.getText().toString());
        if (sl >= 10) {
            viewHolder.btnPlus.setVisibility(View.INVISIBLE);
            viewHolder.btnMinus.setVisibility(View.VISIBLE);
        } else if (sl <= 1) {
            viewHolder.btnMinus.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.btnPlus.setVisibility(View.VISIBLE);
            viewHolder.btnMinus.setVisibility(View.VISIBLE);
        }
        viewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(viewHolder.btnValues.getText().toString()) + 1;
                int slht = MainActivity.mangGiohang.get(position).getSoluongsp();
                long giaht = MainActivity.mangGiohang.get(position).getGiasp();
                MainActivity.mangGiohang.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) / slht;
                MainActivity.mangGiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                viewHolder.txtGiaGioHang.setText("Giá: " + decimalFormat.format(giamoinhat) + " Đ");
                GioHangActivity.EvenUltil();
                if (slmoinhat > 9) {
                    viewHolder.btnPlus.setVisibility(View.INVISIBLE);
                    viewHolder.btnMinus.setVisibility(View.VISIBLE);
                    viewHolder.btnValues.setText(String.valueOf(slmoinhat));
                } else {
                    viewHolder.btnPlus.setVisibility(View.VISIBLE);
                    viewHolder.btnMinus.setVisibility(View.VISIBLE);
                    viewHolder.btnValues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(viewHolder.btnValues.getText().toString()) - 1;
                int slht = MainActivity.mangGiohang.get(position).getSoluongsp();
                long giaht = MainActivity.mangGiohang.get(position).getGiasp();
                MainActivity.mangGiohang.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) / slht;
                MainActivity.mangGiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                viewHolder.txtGiaGioHang.setText("Giá: " + decimalFormat.format(giamoinhat) + " Đ");
                GioHangActivity.EvenUltil();
                if (slmoinhat < 2) {
                    viewHolder.btnMinus.setVisibility(View.INVISIBLE);
                    viewHolder.btnPlus.setVisibility(View.VISIBLE);
                    viewHolder.btnValues.setText(String.valueOf(slmoinhat));
                } else {
                    viewHolder.btnMinus.setVisibility(View.VISIBLE);
                    viewHolder.btnPlus.setVisibility(View.VISIBLE);
                    viewHolder.btnValues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        return convertView;
    }
}
