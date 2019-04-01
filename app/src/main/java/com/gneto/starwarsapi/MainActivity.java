package com.gneto.starwarsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    ListView lvlistaPersonagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new BDSQLiteHelper(this);

        lvlistaPersonagens = (ListView)findViewById(R.id.lvListaPersonagens);

        Button btnInserir = (Button)findViewById(R.id.btnInserir);
        Button btnFavorito = (Button)findViewById(R.id.btnFavorite);

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InserirActivity.class);
                startActivity(intent);
            }
        });

        btnFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VotarActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart() {
        super.onStart();

        final ArrayList<Personagem> listaPersonagens = bd.getAllPersonagens();
        ArrayAdapter<Personagem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPersonagens);
        lvlistaPersonagens.setAdapter(adapter);

        lvlistaPersonagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AlterarActivity.class);

                intent.putExtra("id", listaPersonagens.get(position).getId());
                startActivity(intent);
            }
        });
    }
}
