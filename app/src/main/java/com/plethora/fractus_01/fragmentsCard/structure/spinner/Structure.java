package com.plethora.fractus_01.fragmentsCard.structure.spinner;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.plethora.fractus_01.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Structure extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    FloatingActionButton fabAdd;
    private Sector sector;
    ArrayList<Element> moviesList;
    private static AtomicLong idCounter = new AtomicLong();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList = new ArrayList<>();

        sector = new Sector();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(moviesList, sector);

        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxCount = 0;  //счетчик номера яруса
                ElementRecyclerTier elementRecyclerTier = new ElementRecyclerTier(); //новы объект элемент - ЯРус
                elementRecyclerTier.setId(createID());    // ставим id на ярус


                for (Element e : moviesList) {
                    if (e.getType() == Element.TYPE_TIER) {
                        if (maxCount < e.getNumber()) {
                            maxCount = e.getNumber();
                        }
                    }
                }

                elementRecyclerTier.setNumber(maxCount + 1);
                elementRecyclerTier.setName("Tier " + elementRecyclerTier.getNumber());  //ставим имя
                moviesList.add(elementRecyclerTier);//  добавляем ярус в лист
                recyclerAdapter.notifyItemInserted(moviesList.indexOf(elementRecyclerTier));  //обновление графической части адаптера

                ElementRecyclerRow elementRecyclerRow = new ElementRecyclerRow().createElement(elementRecyclerTier.getId()); //поле 1
                ElementRecyclerRow elementRecyclerRow1 = new ElementRecyclerRow().createElement(elementRecyclerTier.getId()); //поле 2

                elementRecyclerRow.setNumber(1);
                moviesList.add(elementRecyclerRow);
                recyclerAdapter.notifyItemInserted(moviesList.indexOf(elementRecyclerRow));
                elementRecyclerTier.setCountRow(1);

                elementRecyclerRow1.setNumber(2);
                moviesList.add(elementRecyclerRow1);
                recyclerAdapter.notifyItemInserted(moviesList.indexOf(elementRecyclerRow1));
                elementRecyclerTier.setCountRow(elementRecyclerTier.getCountRow() + 1);

                sector.setCountTier(sector.getCountTier() + 1);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHandler(0,
                        ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(recyclerView);

    }


    public static long createID() {
        return idCounter.getAndIncrement();
    }


    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {    //Класс для свайпа и удаление элемента

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override  //сдвиг
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int from = viewHolder.getAdapterPosition();
            int to = target.getAdapterPosition();

            Collections.swap(recyclerAdapter.getMoviesList(), from, to);
            recyclerAdapter.notifyItemMoved(from, to);


            return true;
        }

        @Override       //дествие при свайпе
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            recyclerAdapter.deleteRow(viewHolder.getAdapterPosition());

        }

        @Override      //Запрет на свайп ярусу
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int dragFlags = 0;
            int swipeFlags = 0;
            if(recyclerAdapter.getMoviesList().get(viewHolder.getAdapterPosition()).getType()==Element.TYPE_TIER) {

                swipeFlags = 0;
            } else {
                swipeFlags = ItemTouchHelper.LEFT;
            }
            return makeMovementFlags(dragFlags, swipeFlags);
        }

    }
}
