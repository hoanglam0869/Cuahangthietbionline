package com.hoanglam0869.cuahangthietbionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoanglam0869.cuahangthietbionline.R;
import com.hoanglam0869.cuahangthietbionline.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayListLoaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListLoaisp, Context context) {
        this.arrayListLoaisp = arrayListLoaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLoaisp.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListLoaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtTenLoaisp;
        ImageView imgLoaisp;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_loaisp, null);
            viewHolder.txtTenLoaisp = convertView.findViewById(R.id.textViewLoaisp);
            viewHolder.imgLoaisp = convertView.findViewById(R.id.imageViewLoaisp);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Loaisp loaisp = (Loaisp) getItem(position);
        viewHolder.txtTenLoaisp.setText(loaisp.getTenloaisp());
        Picasso.get().load(loaisp.getHinhanhloaisp()).into(viewHolder.imgLoaisp);
                /*.placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgLoaisp);*/
        return convertView;
    }
}
