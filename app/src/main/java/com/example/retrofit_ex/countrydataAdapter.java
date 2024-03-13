package com.example.retrofit_ex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class countrydataAdapter extends RecyclerView.Adapter<countrydataAdapter.countryview> {

     private ArrayList<countryModel> countrylist;

    public countrydataAdapter(ArrayList<countryModel> countrylist) {
        this.countrylist = countrylist;
    }

    @NonNull
    @Override
    public countryview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
     return new countryview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull countryview holder, int position) {
          holder.c_txt.setText(countrylist.get(position).getName());
          holder.r_txt.setText(countrylist.get(position).getRegion());
          holder.code_txt.setText(countrylist.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return countrylist.size();
    }

    class countryview extends RecyclerView.ViewHolder{

        TextView c_txt,r_txt,code_txt;
        public countryview(@NonNull View itemView) {
            super(itemView);
            c_txt = itemView.findViewById(R.id.c_name);
            r_txt = itemView.findViewById(R.id.c_region);
            code_txt = itemView.findViewById(R.id.c_code);
        }
    }
}
