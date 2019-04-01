package com.gneto.starwarsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.EasyEditSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InserirActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);
        bd = new BDSQLiteHelper(this);


        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
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

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personagem person = new Personagem();
                person.setName(edtNome.getText().toString());
                person.setHeith(Float.parseFloat(edtAltura.getText().toString()));
                person.setMass(Integer.parseInt(edtPeso.getText().toString()));
                person.setHair_color(edtCorCabelo.getText().toString());
                person.setSkin_color(edtCorPele.getText().toString());
                person.setEye_color(edtCorOlhos.getText().toString());
                person.setBirth_year(Integer.parseInt(edtAnoNascimento.toString()));
                person.setGender(edtGenero.getText().toString());
                person.setNome_do_planeta_natal(edtPlanetLand.getText().toString());
                person.setNome_da_especie(edtSpeciesName.getText().toString());
                bd.addPersonagem(person);
                Toast.makeText(getBaseContext(), "Personagem inserido com sucesso",
                        Toast.LENGTH_LONG).show();
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}