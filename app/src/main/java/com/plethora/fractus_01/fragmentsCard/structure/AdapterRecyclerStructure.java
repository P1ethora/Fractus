package com.plethora.fractus_01.fragmentsCard.structure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.plethora.fractus_01.R;
import com.plethora.fractus_01.graphical_display.graphical_model.home.ItemDistrict;
import com.plethora.fractus_01.graphical_display.graphical_model.listQuarter.NewForesty;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecyclerStructure extends RecyclerView.Adapter<AdapterRecyclerStructure.StructureViewHolder> {


    private EmailAdapterListener listener;
    private final List<ItemDistrict> itemDistricts;
    final SparseBooleanArray selectedItems = new SparseBooleanArray();
    private int currentSelectedPos;

    AdapterRecyclerStructure(List<ItemDistrict> itemDistricts) {
        this.itemDistricts = itemDistricts;
    }

    public List<ItemDistrict> getItemDistricts() {
        return itemDistricts;
    }

    public void setListener(EmailAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StructureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.email_item, parent, false);
        return new StructureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StructureViewHolder holder, final int position) {
        ItemDistrict itemDistrict = itemDistricts.get(position);
        holder.bind(itemDistrict);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                      //Добавляем объект к общему выделению
                if (selectedItems.size() > 0 && listener != null)
                    listener.onItemClick(position);

                else {
                    Intent intent = new Intent(view.getContext(), NewForesty.class);   //если выделение не активировано и произошел клик открываем
                    intent.putExtra("title", String.valueOf(getItemDistricts().get(position))); //список выделов
                    view.getContext().startActivity(intent);
                }
            }

        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null)
                    listener.onItemLongClick(position);
                return true;
            }
        });


        if (currentSelectedPos == position) currentSelectedPos = -1;
    }

    @Override
    public int getItemCount() {
        return itemDistricts.size();
    }

    void deleteEmails() {
        List<ItemDistrict> itemDistricts = new ArrayList<>();
        for (ItemDistrict itemDistrict : this.itemDistricts) {
            if (itemDistrict.isSelected())
                itemDistricts.add(itemDistrict);
        }

        this.itemDistricts.removeAll(itemDistricts);
        notifyDataSetChanged();
        currentSelectedPos = -1;
    }

    void toggleSelection(int position) {
        currentSelectedPos = position;
        if (selectedItems.get(position)) {
            selectedItems.delete(position);
            itemDistricts.get(position).setSelected(false);
        } else {
            selectedItems.put(position, true);
            itemDistricts.get(position).setSelected(true);
        }
        notifyItemChanged(position);
    }

    class StructureViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser;
        TextView txtIcon;
        TextView txtSubject;
        TextView txtPreview;
        TextView txtDate;

        StructureViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUser = itemView.findViewById(R.id.txt_user);
            txtIcon = itemView.findViewById(R.id.txt_icon);
            txtSubject = itemView.findViewById(R.id.txt_subject);
            txtPreview = itemView.findViewById(R.id.txt_preview);
            txtDate = itemView.findViewById(R.id.txt_date);


        }


        void bind(ItemDistrict itemDistrict) {
            int hash = itemDistrict.getNameDistrict().hashCode();
            txtIcon.setText(String.valueOf(itemDistrict.getNameDistrict().charAt(0)));
            txtIcon.setBackground(oval(Color.rgb(hash, hash / 2, 0), txtIcon));
            txtUser.setText(itemDistrict.getNameDistrict());
            txtSubject.setText(itemDistrict.getSubject());
            txtPreview.setText(itemDistrict.getPreview());
            txtDate.setText(itemDistrict.getDate());

          //  txtUser.setTypeface(Typeface.DEFAULT, itemDistrict.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
           // txtSubject.setTypeface(Typeface.DEFAULT, itemDistrict.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
           // txtDate.setTypeface(Typeface.DEFAULT, itemDistrict.isUnread() ? Typeface.BOLD : Typeface.NORMAL);


            if (itemDistrict.isSelected()) {
                txtIcon.setBackground(oval(Color.rgb(26, 115, 233), txtIcon));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                //gradientDrawable.setCornerRadius(32f);
                gradientDrawable.setColor(Color.rgb(232, 240, 253));
                itemView.setBackground(gradientDrawable);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                gradientDrawable.setCornerRadius(32f);
                gradientDrawable.setColor(Color.WHITE);
                itemView.setBackground(gradientDrawable);
            }

            // animation
            if (selectedItems.size() > 0)
                animate(txtIcon, itemDistrict);


        }

        private void animate(final TextView view, final ItemDistrict itemDistrict) {
            ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.setDuration(200);
            oa2.setDuration(200);

            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    if (itemDistrict.isSelected())
                        view.setText("\u2713");
                    oa2.start();
                }
            });
            oa1.start();
        }

    }

    private static ShapeDrawable oval(@ColorInt int color, View view) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(view.getHeight());
        shapeDrawable.setIntrinsicWidth(view.getWidth());
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    interface EmailAdapterListener {
        void onItemClick(int position);

        void onItemLongClick(int position);
    }










































/*
    private StructureAdapterListener listener;
    private final List<ItemStructure> itemStructures;
    private int currentSelectedPos;

    AdapterRecyclerStructure(List<ItemStructure> itemStructures) {
        this.itemStructures = itemStructures;
    }

    public List<ItemStructure> getEmails() {
        return itemStructures;
    }

    public void setListener(StructureAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StructureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_structure, parent, false);
        return new StructureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StructureViewHolder holder, final int position) {
        ItemStructure itemStructure = itemStructures.get(position);
        holder.bind(itemStructure);

    }

    @Override
    public int getItemCount() {
        return itemStructures.size();
    }
/*
    void deleteEmails() {
        List<ItemStructure> emails = new ArrayList<>();
        for (ItemStructure itemStructure : this.emails) {
            if (email.isSelected())
                emails.add(email);
        }

        this.emails.removeAll(emails);
        notifyDataSetChanged();
        currentSelectedPos = -1;
    }

    class StructureViewHolder extends RecyclerView.ViewHolder {

        EditText txtYarus;
        EditText txtCoef;
        EditText txtTypeTree;
        EditText txtA;
        EditText txtH;
        EditText txtD;
        EditText txtKLT;

        StructureViewHolder(@NonNull View itemView) {
            super(itemView);
            txtYarus = itemView.findViewById(R.id.Yarus);
            txtCoef = itemView.findViewById(R.id.Coef);
            txtTypeTree = itemView.findViewById(R.id.TypeTree);
            txtA = itemView.findViewById(R.id.A);
            txtH = itemView.findViewById(R.id.H);
            txtD = itemView.findViewById(R.id.D);
            txtKLT = itemView.findViewById(R.id.KLT);



        }


        void bind(ItemStructure itemStructure) {
            //int hash = itemStructure.get.hashCode();
            //txtIcon.setText(String.valueOf(email.getNameDistrict().charAt(0)));
           // txtIcon.setBackground(oval(Color.rgb(hash, hash / 2, 0), txtIcon));
            txtYarus.setText(itemStructure.getYarus());
            txtCoef.setText(itemStructure.getCoef());
            txtTypeTree.setText(itemStructure.getTypeTree());
            txtA.setText(itemStructure.getA());
            txtH.setText(itemStructure.getH());
            txtD.setText(itemStructure.getD());
            txtKLT.setText(itemStructure.getKLT());

            //txtUser.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            //txtSubject.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            //txtDate.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);








        }

    }

    interface StructureAdapterListener {
        void onItemClick(int position);

        void onItemLongClick(int position);
    }
*/
}
