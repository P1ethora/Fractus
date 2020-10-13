package com.plethora.fractus_01.fragmentsCard.structure.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import com.plethora.fractus_01.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<Element> moviesList;
    private Context mContext;

    private ElementRecyclerTier elementRecyclerTier;
    private HashMap<Integer, Element> temporaryElement;
    private Sector sector;

    public RecyclerAdapter(ArrayList<Element> moviesList, Sector sector) {
        this.moviesList = moviesList;
        this.sector = sector;

    }

    @Override
    public int getItemViewType(int position) {


        if (moviesList.get(position).getType() == 0) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;

        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.element_recycler_tier, parent, false);
            return new ViewHolderOne(view);
        }

        view = layoutInflater.inflate(R.layout.element_recycler_row, parent, false);
        return new ViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (moviesList.get(position).getType() == 0) {
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            viewHolderOne.tierName.setText(moviesList.get(position).getName());
            mContext = viewHolderOne.menuPop.getContext();

            viewHolderOne.menuPop.setOnClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(((ViewHolderOne) holder).menuPop.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item_tier, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.tier_delete:
                            elementRecyclerTier = new ElementRecyclerTier();
                            elementRecyclerTier.setName(moviesList.get(position).getName());
                            elementRecyclerTier.setId(moviesList.get(position).getId());
                            elementRecyclerTier.setNumber(moviesList.get(position).getNumber());

                            deleteItemTier(v, position);


                            break;
                        case R.id.tier_add_line:
                            Element tier = moviesList.get(position);
                            int numberPositionForAdd = 0;
                            long numberIdTier = tier.getId();

                            ElementRecyclerRow elementRecyclerRow = new ElementRecyclerRow()
                                    .createElement(moviesList.get(position).getId());

                            for (int i = 0; i < moviesList.size(); i++) {
                                if (moviesList.get(i).getId() == tier.getId()) {
                                    numberPositionForAdd++;
                                }
                            }
                            moviesList.add(position + numberPositionForAdd, new ElementRecyclerRow().createElement(numberIdTier));
                            moviesList.get(position).setCountRow(moviesList.get(position).getCountRow() + 1);
                            notifyDataSetChanged();

                            break;
                    }
                    return false;
                });
            });

        } else {

            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;

        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {

        private TextView tierName;
        private ImageView menuPop;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tierName = itemView.findViewById(R.id.tier_name);
            menuPop = itemView.findViewById(R.id.button_menu_tier);

        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {

        Spinner spinnerCoef;
        Spinner spinnerTypeTree;
        Spinner spinnerA;
        Spinner spinnerH;
        Spinner spinnerD;
        Spinner spinnerKLT;

        TextView textSpinCoef;
        TextView textSpinTypeTree;
        TextView textSpinA;
        TextView textSpinH;
        TextView textSpinD;
        TextView textSpinKLT;


        public ArrayList<String> typeTreeList;
        public ArrayList<String> valueCoef;
        public ArrayList<String> valueA;
        public ArrayList<String> valueH;
        public ArrayList<String> valueD;
        public ArrayList<String> valueKLT;

        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            spinnerCoef = itemView.findViewById(R.id.spin_coef);
            spinnerTypeTree = itemView.findViewById(R.id.spin_typeTree);
            spinnerA = itemView.findViewById(R.id.spin_A);
            spinnerH = itemView.findViewById(R.id.spin_H);
            spinnerD = itemView.findViewById(R.id.spin_D);
            spinnerKLT = itemView.findViewById(R.id.spin_KLT);

            textSpinCoef = itemView.findViewById(R.id.text_spinn_coef);
            textSpinTypeTree = itemView.findViewById(R.id.text_spin_typeTree);
            textSpinA = itemView.findViewById(R.id.text_spin_A);
            textSpinH = itemView.findViewById(R.id.text_spin_H);
            textSpinD = itemView.findViewById(R.id.text_spin_D);
            textSpinKLT = itemView.findViewById(R.id.text_spin_KLT);



//////////////////////////////////////////////////////////////////////////////////////////////////////
            valueCoef = new ArrayList<>();
            valueCoef.add("Nothing");
            valueCoef.add("1");
            valueCoef.add("2");
            valueCoef.add("3");
            valueCoef.add("4");
            valueCoef.add("5");
            valueCoef.add("6");
            valueCoef.add("7");
            valueCoef.add("8");
            valueCoef.add("9");
            valueCoef.add("10");
            //valueCoef.add(" ");
            //valueCoef.add(" ");
            CustomAdapter customAdapterCoef = new CustomAdapter(mContext, R.layout.style_spinner, valueCoef);
            spinnerCoef.setAdapter(customAdapterCoef);
            //spinnerCoef.setSelection(valueCoef.size() - 1);
            spinnerCoef.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (String.valueOf(parent.getItemAtPosition(position)).equals("Nothing")) {
                        textSpinCoef.setText(" ");
                    } else
                        textSpinCoef.setText(String.valueOf(parent.getItemAtPosition(position)));
                        //valueCoef.set(valueCoef.size() - 2, " ");
                    /* else if (String.valueOf(parent.getItemAtPosition(position)).equals(" ")) {
                        valueCoef.set(valueCoef.size() - 2, " ");
                    } else {
                        valueCoef.set(valueCoef.size() - 2, String.valueOf(parent.getItemAtPosition(position)));
                    }
                    spinnerCoef.setSelection(valueCoef.size() - 2);*/
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
/////////////////////////////////////////////////////////////////////////////////////////////////////
            typeTreeList = new ArrayList<>();
            typeTreeList.add("Nothing");
            typeTreeList.add("Сосна");
            typeTreeList.add("Ель");
            typeTreeList.add("Береза");
            typeTreeList.add("Осина");
            typeTreeList.add("Ольха серая");
            typeTreeList.add("Ольха черная");
            typeTreeList.add("Дуб");
            typeTreeList.add("Ясень");
            typeTreeList.add("Вяз");
            typeTreeList.add("Клен");
            typeTreeList.add("Каштан");
            typeTreeList.add("Липа");


            CustomAdapter customAdapterTree = new CustomAdapter(mContext, R.layout.style_spinner, typeTreeList);
            spinnerTypeTree.setAdapter(customAdapterTree);


            spinnerTypeTree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (String.valueOf(parent.getItemAtPosition(position)).equals("Nothing")) {
                        textSpinTypeTree.setText(" ");
                       // typeTreeList.set(typeTreeList.size() - 2, " ");
                    } else if (String.valueOf(parent.getItemAtPosition(position)).equals("Ольха серая")) {
                        textSpinTypeTree.setText("Олс");
                        //typeTreeList.set(typeTreeList.size() - 2, "Олс");
                    } //else if (String.valueOf(parent.getItemAtPosition(position)).equals("Прд")) {
                      //  typeTreeList.set(typeTreeList.size() - 2, "Прд");
                     else if (String.valueOf(parent.getItemAtPosition(position)).equals("Ольха черная")) {
                        textSpinTypeTree.setText("Олч");
                        //typeTreeList.set(typeTreeList.size() - 2, "Олч");
                    } else if (String.valueOf(parent.getItemAtPosition(position)).equals("Клен")) {
                         textSpinTypeTree.setText("Кл");
                        //typeTreeList.set(typeTreeList.size() - 2, "Кл");
                    } else {
                        textSpinTypeTree.setText(String.valueOf(parent.getItemAtPosition(position)).substring(0, 1).toUpperCase());
                        //typeTreeList.set(typeTreeList.size() - 2, String.valueOf(parent.getItemAtPosition(position)).substring(0, 1).toUpperCase());
                    }
                    //spinnerTypeTree.setSelection(0);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            //TODO TEST TABLES
/////////////////////////////////////////////////////////////////////////////////////////////////////
            valueA = new ArrayList<>();
            valueA.add("Nothing");
            valueA.add("10");
            valueA.add("15");
            valueA.add("20");
            valueA.add("25");
            valueA.add("30");
            valueA.add("35");
            valueA.add("45");
            valueA.add("50");
            valueA.add("55");
            valueA.add("60");
            valueA.add("65");
            valueA.add("75");
            valueA.add("80");
            valueA.add("85");
            valueA.add("90");
            valueA.add("95");
            valueA.add("100");
            valueA.add("105");
            valueA.add("110");
            valueA.add("120");
            valueA.add("130");
           // valueA.add(" ");
           // valueA.add(" ");

            CustomAdapter customAdapterA = new CustomAdapter(mContext, R.layout.style_spinner, valueA);
            spinnerA.setAdapter(customAdapterA);
            //spinnerA.setSelection(customAdapterA.getCount());
            spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(parent.getItemAtPosition(position).equals("Nothing"))
                        textSpinA.setText(" ");
                    else
                        textSpinA.setText(String.valueOf(parent.getItemAtPosition(position)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

////////////////////////////////////////////////////////////////////////////////////////////////////

            valueH = new ArrayList<>();
            valueH.add("Nothing");
            valueH.add("8");
            valueH.add("9");
            valueH.add("10");
            valueH.add("11");
            valueH.add("12");
            valueH.add("13");
            valueH.add("14");
            valueH.add("15");
            valueH.add("16");
            valueH.add("17");
            valueH.add("18");
            valueH.add("19");
            valueH.add("20");
            valueH.add("21");
            valueH.add("22");
            valueH.add("23");
            valueH.add("24");
            valueH.add("25");
            valueH.add("26");
            valueH.add("27");
            valueH.add("28");
            valueH.add("29");
            valueH.add("30");
            valueH.add("31");
            //valueH.add(" ");
            //valueH.add(" ");

            CustomAdapter customAdapterH = new CustomAdapter(mContext, R.layout.style_spinner, valueH);
            spinnerH.setAdapter(customAdapterH);

            spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(parent.getItemAtPosition(position).equals("Nothing"))
                        textSpinH.setText(" ");
                    else
                        textSpinH.setText(String.valueOf(parent.getItemAtPosition(position)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            //spinnerH.setSelection(customAdapterH.getCount());
/////////////////////////////////////////////////////////////////////////////////////////////////////

            valueD = new ArrayList<>();
            valueD.add("Nothing");
            valueD.add("10");
            valueD.add("12");
            valueD.add("14");
            valueD.add("16");
            valueD.add("18");
            valueD.add("20");
            valueD.add("22");
            valueD.add("24");
            valueD.add("26");
            valueD.add("28");
            valueD.add("32");
            valueD.add("34");
            valueD.add("36");
            valueD.add("38");
            valueD.add("40");
            valueD.add("42");
            valueD.add("44");
            valueD.add("46");
            valueD.add("48");
            valueD.add("50");
            valueD.add("60");
            valueD.add("70");
            //valueD.add(" ");
            //valueD.add(" ");

            CustomAdapter customAdapterD = new CustomAdapter(mContext, R.layout.style_spinner, valueD);
            spinnerD.setAdapter(customAdapterD);

            spinnerD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(parent.getItemAtPosition(position).equals("Nothing"))
                        textSpinD.setText(" ");
                    else
                        textSpinD.setText(String.valueOf(parent.getItemAtPosition(position)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //spinnerD.setSelection(customAdapterD.getCount());
////////////////////////////////////////////////////////////////////////////////////////////////////

            valueKLT = new ArrayList<>();
            valueKLT.add("Nothing");
            valueKLT.add("1");
            valueKLT.add("2");
            valueKLT.add("3");
            valueKLT.add("4");
           // valueKLT.add(" ");
           // valueKLT.add(" ");

            CustomAdapter customAdapterKLT = new CustomAdapter(mContext, R.layout.style_spinner, valueKLT);
            spinnerKLT.setAdapter(customAdapterKLT);

            spinnerKLT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(parent.getItemAtPosition(position).equals("Nothing"))
                        textSpinKLT.setText(" ");
                    else
                    textSpinKLT.setText(String.valueOf(parent.getItemAtPosition(position)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            //spinnerKLT.setSelection(customAdapterKLT.getCount());

        }
    }


    private void deleteItemTier(View view, int position) {
        int count = 0;
        int countChang = 0;
        long needId = moviesList.get(position).getId();
        Iterator<Element> iterator = moviesList.iterator();

        while (iterator.hasNext()) {//до тех пор, пока в списке есть элементы

            Element nextElement = iterator.next();//получаем следующий элемент
            if (nextElement.getId() == needId) {
                iterator.remove();//удаляем кота с нужным именем
                count += 1;
            } else if (nextElement.getType() == Element.TYPE_TIER) {
                if (nextElement.getNumber() > elementRecyclerTier.getNumber()) {
                    nextElement.setNumber(nextElement.getNumber() - 1);
                    nextElement.setName("Tier " + nextElement.getNumber());
                    countChang += 1;
                }
            }
        }

        sector.setCountTier(sector.getCountTier() - 1);
        notifyDataSetChanged();


        /*for (Element e : moviesList) {
            if (e.getId() == elementRecyclerTier.getId()) {
                moviesList.remove(moviesList.indexOf(e));

            }
        }*/


        /*for(int i = position; i<=moviesList.get(position).getCountRow() + position;i++) {
            if (moviesList.get(i).getId() == moviesList.get(position).getId()) {
                temporaryElement = new HashMap<>();
                temporaryElement.put(moviesList.indexOf( moviesList.get(i)) , moviesList.get(i));
                moviesList.remove(moviesList.get(i));
                //count+=1;
            }

        }*/
        //moviesList.remove(position);


     /*   Snackbar.make(view, "Undo deletion of: " + elementRecyclerTier.getName(), Snackbar.LENGTH_LONG)
                .setAction("UNDO", v -> {
                    moviesList.add(position, elementRecyclerTier);
                    //HashMap<String, HashMap> selects = new HashMap<String, HashMap>();
                    for(Map.Entry<Integer, Element> entry : temporaryElement.entrySet()) {
                    moviesList.add(entry.getKey(),entry.getValue());}
                    notifyItemRangeInserted(position,temporaryElement.size());
                }).setActionTextColor(mContext.getResources().getColor(android.R.color.holo_blue_bright))
                .show();*/
    }


    public void deleteRow(int position) {

        moviesList.remove(position);
        notifyDataSetChanged();

}

    public ArrayList<Element> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(ArrayList<Element> moviesList) {
        this.moviesList = moviesList;
    }

}