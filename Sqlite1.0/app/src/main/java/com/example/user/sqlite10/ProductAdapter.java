package com.example.user.sqlite10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private LayoutInflater layoutInflater;
    private ArrayList<Product> products;
    private int ViewResourceId;


    public ProductAdapter(Context context,int textViewResourceId,ArrayList<Product> products){

        super(context,textViewResourceId,products);
        this.products=products;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewResourceId=textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        convertView=layoutInflater.inflate(ViewResourceId,null);

        Product product = products.get(position);

        String proName = product.ProductName;
        String proCategory= product.Category;
        String proDescription=product.Description;
        double proPrice = product.Price;
        int proQty = product.Quantity;

        TextView productName = (TextView) convertView.findViewById(R.id.proName);
        TextView productDes = (TextView) convertView.findViewById(R.id.proDescription);
        TextView productPrice = (TextView) convertView.findViewById(R.id.proPrice);
        TextView productQuantity = (TextView) convertView.findViewById(R.id.proQuantity);
        ImageView productIcon=(ImageView)convertView.findViewById(R.id.productIcon);

        switch (proCategory){
            case "Food":
                productIcon.setImageResource(R.drawable.breakfast);
                break;

            case "Cosmatic":
                productIcon.setImageResource(R.drawable.cosmetics);
                break;

            case "Stationary":
                productIcon.setImageResource(R.drawable.stationary);
                break;
        }

        productName.setText(proName);
        productDes.setText(proDescription);
        productPrice.setText(Double.toString(proPrice));
        productQuantity.setText(Integer.toString(proQty));

        //ImageView image =(ImageView)cusView.findViewById(R.id.image);
        //image.setImageResource(R.drawable.ic_launcher_foreground);

        return convertView;
    }
}
