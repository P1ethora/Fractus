package com.plethora.fractus_01.fragmentsCard.structure.testActiv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.plethora.fractus_01.R;
import com.plethora.fractus_01.fragmentsCard.structure.ItemStructure;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;

    //we are storing all the products in a list
    private List<ItemStructure> itemList;

    public List<ItemStructure> getItemList(){
        return itemList;
    }


    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<ItemStructure> items) {
        this.mCtx = mCtx;
        this.itemList =items;
    }

    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_structure, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ItemStructure itemStructure = itemList.get(position);

        //binding the data with the viewholder views
        holder.textYarus.setText(String.valueOf(itemStructure.getYarus()));
        holder.textCoef.setText(String.valueOf(itemStructure.getCoef()));
        holder.texTypeTree.setText(String.valueOf(itemStructure.getTypeTree()));
        holder.textA.setText(String.valueOf(itemStructure.getA()));
        holder.textH.setText(String.valueOf(itemStructure.getH()));
        holder.textD.setText(String.valueOf(itemStructure.getD()));
        holder.textKLT.setText(String.valueOf(itemStructure.getKLT()));

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        EditText textYarus, textCoef, texTypeTree, textA, textH, textD, textKLT;

        //ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textYarus = itemView.findViewById(R.id.Yarus);
            textCoef = itemView.findViewById(R.id.Coef);
            texTypeTree= itemView.findViewById(R.id.TypeTree);
            textA = itemView.findViewById(R.id.A);
            textD = itemView.findViewById(R.id.D);
            textH = itemView.findViewById(R.id.H);
            textKLT = itemView.findViewById(R.id.KLT);
        }
    }

}
