package com.hoanglam0869.cuahangthietbionline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoanglam0869.cuahangthietbionline.R;
import com.hoanglam0869.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LaptopAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayLaptop;

    public LaptopAdapter(Context context, ArrayList<Sanpham> arrayLaptop) {
        this.context = context;
        this.arrayLaptop = arrayLaptop;
    }

    @Override
    public int getCount() {
        return arrayLaptop.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayLaptop.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txtTenLaptop, txtGiaLaptop, txtMoTaLaptop;
        public ImageView imgLaptop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_laptop, null);
            viewHolder.txtTenLaptop = convertView.findViewById(R.id.textViewLaptop);
            viewHolder.txtGiaLaptop = convertView.findViewById(R.id.textViewGiaLaptop);
            viewHolder.txtMoTaLaptop = convertView.findViewById(R.id.textViewMoTaLaptop);
            viewHolder.imgLaptop = convertView.findViewById(R.id.imageViewLaptop);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txtTenLaptop.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaLaptop.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + " Đ");
        viewHolder.txtMoTaLaptop.setMaxLines(2);
        viewHolder.txtMoTaLaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMoTaLaptop.setText(sanpham.getMotasanpham());
        Picasso.get().load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgLaptop);
        return convertView;
    }
}
