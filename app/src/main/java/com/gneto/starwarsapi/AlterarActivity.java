package com.gneto.starwarsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarActivity extends AppCompatActivity {

    BDSQLiteHelper bd;
    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        bd = new BDSQLiteHelper(this);

        Button btnConfirmar = (Button)findViewById(R.id.btnConfirmar);
        final EditText edtNome = (EditText) findViewById(R.id.edtName);
        final EditText edtAltura = (EditText) findViewById(R.id.edtHeith);
        final EditText edtPeso = (EditText) findViewById(R.id.edtMass);
        final EditText edtCorCabelo = (EditText) findViewById(R.id.edtHairColor);
        final EditText edtCorPele = (EditText) findViewById(R.id.edtSkinColor);
        final EditText edtCorOlhos = (EditText) findViewById(R.id.edtEyeColor);
        final EditText edtAnoNascimento = (EditText) findViewById(R.id.edtBirthYear);
        final EditText edtGenero = (EditText) findViewById(R.id.edtGender);
        final EditText edtPlanetLand = (EditText) findViewById(R.id.edtNomeDoPlanetaNatal);
        final EditText edtSpeciesName = (EditText) findViewById(R.id.edtNomeDaEspecie);

        edtNome.setText(personagem.getName());
        edtAltura.setText(String.valueOf(personagem.getHeith()));
        edtPeso.setText(String.valueOf(personagem.getMass()));
        edtCorCabelo.setText(personagem.getHair_color());
        edtCorPele.setText(personagem.getSkin_color());
        edtCorOlhos.setText(personagem.getEye_color());
        edtAnoNascimento.setText(String.valueOf(personagem.getBirth_year()));
        edtGenero.setText(personagem.getGender());
        edtPlanetLand.setText(personagem.getNome_do_planeta_natal());
        edtSpeciesName.setText(personagem.getNome_do_planeta_natal());

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personagem.setName(edtNome.getText().toString());
                personagem.setHeith(Float.parseFloat(edtAltura.getText().toString()));
                personagem.setMass(Float.parseFloat(edtPeso.getText().toString()));
                personagem.setHair_color(edtCorCabelo.getText().toString());
                personagem.setSkin_color(edtCorPele.getText().toString());
                personagem.setEye_color(edtCorOlhos.getText().toString());
                personagem.setBirth_year(Integer.parseInt(edtAnoNascimento.getText().toString()));
                personagem.setGender(edtGenero.getText().toString());
                personagem.setNome_do_planeta_natal(edtPlanetLand.getText().toString());
                personagem.setNome_da_especie(edtSpeciesName.getText().toString());
                Toast.makeText(getApplicationContext(), "Personagem Alterado com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
