package com.example.foodusmanproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodusmanproject.DBHelper;
import com.example.foodusmanproject.DetailActivity;
import com.example.foodusmanproject.Models.OrderModel;
import com.example.foodusmanproject.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {
    ArrayList<OrderModel> list;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModel model=list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));
               intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DBHelper helper=new DBHelper(context);
                if (helper.deleteOrder(model.getOrderNumber())>0){
                    Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Eroor", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView soldItemName,orderNumber,price;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderimage);
            soldItemName=itemView.findViewById(R.id.orderitemName);
            orderNumber=itemView.findViewById(R.id.orderNumber);
            price=itemView.findViewById(R.id.orderPrice);


        }
    }
}
