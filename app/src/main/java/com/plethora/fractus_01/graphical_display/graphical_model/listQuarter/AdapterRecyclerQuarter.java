package com.plethora.fractus_01.graphical_display.graphical_model.listQuarter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.plethora.fractus_01.R;
import com.plethora.fractus_01.graphical_display.graphical_model.listSection.SectionList;
import com.plethora.fractus_01.model.Quarter;
import com.plethora.fractus_01.model.logic.SelectionState;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterRecyclerQuarter extends RecyclerView.Adapter<AdapterRecyclerQuarter.ViewHolderQuarter> {
    private List<Quarter> recyclerItemList;
    private Context context;


    public AdapterRecyclerQuarter(List<Quarter> recyclerItemList, Context context) {
        this.recyclerItemList = recyclerItemList;
        this.context = context;

    }


    @NonNull
    @Override
    public AdapterRecyclerQuarter.ViewHolderQuarter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_quarter,parent,false);
        return new ViewHolderQuarter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQuarter holder, int position) {
        Quarter quarter = recyclerItemList.get(position);
        holder.textNumber.setText(quarter.getRecyclerItemQuarter().getNumber());
    }

    @Override
    public int getItemCount() {
        return recyclerItemList.size();
    }


    public class ViewHolderQuarter extends RecyclerView.ViewHolder {

        public TextView textNumber;



        public ViewHolderQuarter(@NonNull View itemView) {
            super(itemView);
            textNumber = itemView.findViewById(R.id.txtNumberQuarter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), SectionList.class);
                    //intent.putExtra("numberQuarter",getAdapterPosition());
                    SelectionState.selectQuarter = getAdapterPosition();
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}