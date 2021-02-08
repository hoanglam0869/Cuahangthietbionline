package com.hoanglam0869.cuahangthietbionline.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanglam0869.cuahangthietbionline.R;
import com.hoanglam0869.cuahangthietbionline.activity.ChiTietSanPham;
import com.hoanglam0869.cuahangthietbionline.model.Sanpham;
import com.hoanglam0869.cuahangthietbionline.ultil.CheckConnection;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    Context context;
    ArrayList<Sanpham> arraySanPham;

    public SanphamAdapter(Context context, ArrayList<Sanpham> arraySanPham) {
        this.context = context;
        this.arraySanPham = arraySanPham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat, null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Sanpham sanpham = arraySanPham.get(position);
        holder.txtTenSanPham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + " Đ");
        Picasso.get().load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(holder.imgHinhSanPham);
    }

    @Override
    public int getItemCount() {
        return arraySanPham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgHinhSanPham;
        public TextView txtTenSanPham, txtGiaSanPham;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhSanPham = itemView.findViewById(R.id.imageViewSanPham);
            txtGiaSanPham = itemView.findViewById(R.id.textViewGiaSanPham);
            txtTenSanPham = itemView.findViewById(R.id.textViewTenSanPham);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChiTietSanPham.class);
                    intent.putExtra("thongtinsanpham", arraySanPham.get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    CheckConnection.ShowToast_Short(context, arraySanPham.get(getAdapterPosition()).getTensanpham());
                    context.startActivity(intent);
                }
            });
        }
    }
}
