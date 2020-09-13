package com.plethora.fractus_01.graphical_display.graphical_model.home;

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
import com.plethora.fractus_01.graphical_display.graphical_model.listQuarter.NewForesty;
import com.plethora.fractus_01.model.logic.SelectionState;
import com.plethora.fractus_01.model.District;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.EmailViewHolder> {

    private EmailAdapterListener listener;
    private final List<District> itemDistricts;
    final SparseBooleanArray selectedItems = new SparseBooleanArray();
    private int currentSelectedPos;

    DistrictAdapter(List<District> itemDistricts) {
        this.itemDistricts = itemDistricts;
    }

    public List<District> getItemDistricts() {
        return itemDistricts;
    }

    public void setListener(EmailAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.email_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, final int position) {
        final District itemDistrict = itemDistricts.get(position);
        try {
            holder.bind(itemDistrict);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                      //Добавляем объект к общему выделению
                if (selectedItems.size() > 0 && listener != null)
                    listener.onItemClick(position);

                else {
                    SelectionState.file = itemDistrict;
                    Intent intent = new Intent(view.getContext(), NewForesty.class);   //если выделение не активировано и произошел клик открываем

                    //intent.putExtra()
                    //intent.putExtra("title", String.valueOf(getEmails().get(position)));
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
        List<District> itemDistricts = new ArrayList<>();
        for (District itemDistrict : this.itemDistricts) {
            if (itemDistrict.getItemDistrict().isSelected())
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
            itemDistricts.get(position).getItemDistrict().setSelected(false);
        } else {
            selectedItems.put(position, true);
            itemDistricts.get(position).getItemDistrict().setSelected(true);
        }
        notifyItemChanged(position);
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser;
        TextView txtIcon;
        TextView txtSubject;
        TextView txtPreview;
        TextView txtDate;

        EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUser = itemView.findViewById(R.id.txt_user);
            txtIcon = itemView.findViewById(R.id.txt_icon);
            txtSubject = itemView.findViewById(R.id.txt_subject);
            txtPreview = itemView.findViewById(R.id.txt_preview);
            txtDate = itemView.findViewById(R.id.txt_date);


        }


        void bind(District itemDistrict)  {
            try{
            int hash = itemDistrict.getItemDistrict().getNameDistrict().hashCode();
            txtIcon.setText(String.valueOf(itemDistrict.getItemDistrict().getNameDistrict().charAt(0)));
            txtIcon.setBackground(oval(Color.rgb(hash, hash / 2, 0), txtIcon));
            txtUser.setText(itemDistrict.getItemDistrict().getNameDistrict());
            txtSubject.setText(itemDistrict.getItemDistrict().getSubject());
            txtPreview.setText(itemDistrict.getItemDistrict().getPreview());
            txtDate.setText(itemDistrict.getItemDistrict().getDate());} catch (Exception e){
                e.printStackTrace();

            }

            //txtUser.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            //txtSubject.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            //txtDate.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);


            if (itemDistrict.getItemDistrict().isSelected()) {
                txtIcon.setBackground(oval(Color.rgb(26, 115, 233), txtIcon));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                //gradientDrawable.setCornerRadius(32f);
                gradientDrawable.setColor(Color.rgb(232, 240, 253));
                itemView.setBackground(gradientDrawable);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                //gradientDrawable.setCornerRadius(32f);
                gradientDrawable.setColor(Color.WHITE);
                itemView.setBackground(gradientDrawable);
            }

            // animation
            if (selectedItems.size() > 0)
                animate(txtIcon, itemDistrict.getItemDistrict());


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



}