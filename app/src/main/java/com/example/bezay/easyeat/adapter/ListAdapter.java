package com.example.bezay.easyeat.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bezay.easyeat.R;
import com.example.bezay.easyeat.model.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Product>{

    Context context;
    ArrayList<Product> products;
    int resource;

    public ListAdapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.context = context;
        this.resource = resource;
        this.products = products;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row,null,true);
            holder = new ViewHolder();
            ImageView imageView = (ImageView)convertView.findViewById(R.id.h1);
            TextView textName = (TextView)convertView.findViewById(R.id.hotelName);
            TextView textAdd = (TextView)convertView.findViewById(R.id.hotelAdd);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        new DownloadImageTask(holder.imageView).execute(products.get(position).getImage());
        holder.tvName.setText(products.get(position).getName());
        holder.tvAddress.setText(products.get(position).getAddress());

        return convertView;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView tvName;
        public TextView tvAddress;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage){
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {

            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                Log.e("Error",e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}