package com.example.recyclerview2.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview2.Activity.Adapter.Adapter;
import com.example.recyclerview2.Activity.ClickListener;
import com.example.recyclerview2.Activity.Model.Filme;
import com.example.recyclerview2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        //Listagem de filmes

        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //configurar o recyclerView
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(), "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        "Click Longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }



    public void criarFilmes(){

        Filme filme = new Filme("Homem-Aranha","Ação", "2021");
        this.listaFilmes.add(filme);

        filme = new Filme("Boku no Hero", "Anime", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("One Piece", "Anime","2022");
        this.listaFilmes.add(filme);

        filme = new Filme ("Vingadores","Ação","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Jujutsu kaisen","Anime","2021");
        this.listaFilmes.add(filme);

        filme = new Filme("Demon Slayer","Anime","2020");
        this.listaFilmes.add(filme);

        filme = new Filme("Naruto","Anime","2010");
        this.listaFilmes.add(filme);

        filme = new Filme("Troia","Guerra","2008");
        this.listaFilmes.add(filme);

        filme = new Filme("FullMetal Alchimist ","Anime","2011");
        this.listaFilmes.add(filme);

        filme = new Filme("Ron Bugado","Animação","2021");
    }
}