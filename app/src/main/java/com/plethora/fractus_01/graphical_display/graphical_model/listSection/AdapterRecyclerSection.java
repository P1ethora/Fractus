package com.plethora.fractus_01.graphical_display.graphical_model.listSection;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.plethora.fractus_01.R;
import com.plethora.fractus_01.graphical_display.graphical_model.sectionMenu.SectionMenu;
import com.plethora.fractus_01.model.Section;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecyclerSection extends RecyclerView.Adapter<AdapterRecyclerSection.ViewHolderSection> {

    private ArrayList<Section> sections;
    private Context context;

    public AdapterRecyclerSection(ArrayList<Section> recyclerItemList, Context context) {
        this.sections = recyclerItemList;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterRecyclerSection.ViewHolderSection onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_section,parent,false);
        return new AdapterRecyclerSection.ViewHolderSection(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerSection.ViewHolderSection holder, int position) {
        final Section item = sections.get(position);
        holder.textNumber.setText(item.getRecyclerItemSection().getNumber());
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }


    public class ViewHolderSection extends RecyclerView.ViewHolder {

        public TextView textNumber;



        public ViewHolderSection(@NonNull View itemView) {
            super(itemView);
            textNumber = itemView.findViewById(R.id.txtNumberQuarter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SectionMenu.class);
                    intent.putExtra("num", getAdapterPosition());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}
