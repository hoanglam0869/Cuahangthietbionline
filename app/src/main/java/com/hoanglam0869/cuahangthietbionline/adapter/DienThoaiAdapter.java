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

public class DienThoaiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayDienThoai;

    public DienThoaiAdapter(Context context, ArrayList<Sanpham> arrayDienThoai) {
        this.context = context;
        this.arrayDienThoai = arrayDienThoai;
    }

    @Override
    public int getCount() {
        return arrayDienThoai.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayDienThoai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txtTenDienThoai, txtGiaDienThoai, txtMoTaDienThoai;
        public ImageView imgDienThoai;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_dienthoai, null);
            viewHolder.txtTenDienThoai = convertView.findViewById(R.id.textViewDienThoai);
            viewHolder.txtGiaDienThoai = convertView.findViewById(R.id.textViewGiaDienThoai);
            viewHolder.txtMoTaDienThoai = convertView.findViewById(R.id.textViewMoTaDienThoai);
            viewHolder.imgDienThoai = convertView.findViewById(R.id.imageViewDienThoai);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txtTenDienThoai.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaDienThoai.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + " Đ");
        viewHolder.txtMoTaDienThoai.setMaxLines(2);
        viewHolder.txtMoTaDienThoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMoTaDienThoai.setText(sanpham.getMotasanpham());
        Picasso.get().load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgDienThoai);
        return convertView;
    }
}
