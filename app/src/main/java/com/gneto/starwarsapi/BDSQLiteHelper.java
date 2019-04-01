package com.gneto.starwarsapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import javax.crypto.MacSpi;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StarWarsDB";

    private static final String TABELA_PERSONAGENS = "Personagens";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String HEITH = "height";
    private static final String MASS = "mass";
    private static final String HAIR_COLOR = "hair_color";
    private static final String SKIN_COLOR = "skin_color";
    private static final String EYE_COLOR = "eye_color";
    private static final String BIRTH_YEAR = "birth_year";
    private static final String GENDER = "gender";
    private static final String NOME_DO_PLANETA_NATAL = "nome_do_planeta_natal";
    private static final String NOME_DA_ESPECIE = "nome_da_especie";
    private static final String FAVORITE = "favorite";

    private static final String[] COLUNAS = {ID, NAME, HEITH, MASS, HAIR_COLOR, SKIN_COLOR, EYE_COLOR, BIRTH_YEAR, GENDER, NOME_DO_PLANETA_NATAL, NOME_DA_ESPECIE, FAVORITE};

    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase bd) {
        String CREATE_TABLE = "CREATE TABLE Personagens(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name txt, " +
                "heith real, " +
                "mass integer, " +
                "hair_color text, " +
                "eye_color text, " +
                "birth_year integer, " +
                "gender text, " +
                "nome_do_planeta_natal text, " +
                "nome_da_especie text, " +
                "favorite text)";
        bd.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        bd.execSQL("DROP TABLE IF EXISTS Personagens");
    }

    public void addPersonagem(Personagem personagem) {
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues valuos = new ContentValues();
        valuos.put(NAME, personagem.getName());
        valuos.put(HEITH, personagem.getHeith());
        valuos.put(MASS, personagem.getMass());
        valuos.put(HAIR_COLOR, personagem.getHair_color());
        valuos.put(SKIN_COLOR, personagem.getSkin_color());
        valuos.put(EYE_COLOR, personagem.getEye_color());
        valuos.put(BIRTH_YEAR, personagem.getBirth_year());
        valuos.put(GENDER, personagem.getGender());
        valuos.put(NOME_DO_PLANETA_NATAL, personagem.getNome_do_planeta_natal());
        valuos.put(NOME_DA_ESPECIE, personagem.getNome_da_especie());
        valuos.put(FAVORITE, personagem.getFavorite());
        bd.insert(TABELA_PERSONAGENS, null, valuos);
        bd.close();
    }

    public Personagem getPersonagem(int id) {
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = bd.query(TABELA_PERSONAGENS, COLUNAS, "id = ?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor == null) {
            return null;
        }else {
            cursor.moveToFirst();
            Personagem personagem = cursorToPersonagem(cursor);
            return personagem;
        }
    }

    private Personagem cursorToPersonagem(Cursor cursor) {
        Personagem personagem = new Personagem();
        personagem.setId(Integer.parseInt(cursor.getString(0)));
        personagem.setName(cursor.getString((1)));
        personagem.setHeith(Float.parseFloat(cursor.getString(2)));
        personagem.setMass(Float.parseFloat(cursor.getString(3)));
        personagem.setHair_color(cursor.getString(4));
        personagem.setSkin_color(cursor.getString(5));
        personagem.setEye_color(cursor.getString(6));
        personagem.setBirth_year(Integer.parseInt(cursor.getString(7)));
        personagem.setGender(cursor.getString(8));
        personagem.setNome_do_planeta_natal(cursor.getString(9));
        personagem.setNome_da_especie(cursor.getString(10));
        personagem.setFavorite(Integer.parseInt(cursor.getString(11)));
        return personagem;
    }

    public ArrayList<Personagem> getAllPersonagens() {
        ArrayList<Personagem> listaPersonagem = new ArrayList<>();
        String query = "SELECT * FROM " + TABELA_PERSONAGENS;
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Personagem personagem = cursorToPersonagem(cursor);
                listaPersonagem.add(personagem);
            }while
            (cursor.moveToNext());
        }
        return listaPersonagem;
    }

    public Cursor carregaDados() {
        ArrayList<Personagem> listaPersonagem = new ArrayList<>();
        String query = "SELECT * FROM " + TABELA_PERSONAGENS;
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = bd.rawQuery(query, null);
        return cursor;
    }

    public int updatePersonagem(Personagem personagem) {
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, personagem.getName());
        values.put(HEITH, new Float(personagem.getHeith()));
        values.put(MASS, new Float(personagem.getMass()));
        values.put(HAIR_COLOR, personagem.getHair_color());
        values.put(SKIN_COLOR, personagem.getSkin_color());
        values.put(EYE_COLOR, personagem.getEye_color());
        values.put(BIRTH_YEAR, new Integer(personagem.getBirth_year()));
        values.put(GENDER, personagem.getGender());
        values.put(NOME_DO_PLANETA_NATAL, personagem.getNome_do_planeta_natal());
        values.put(NOME_DA_ESPECIE, personagem.getNome_da_especie());
        values.put(FAVORITE, personagem.getFavorite());
        int i = bd.update(TABELA_PERSONAGENS, values, ID + " = ?", new String[]{String.valueOf(personagem.getId())});
        bd.close();
        return i;
    }

    public int deletePersonagem(Personagem personagem) {
        SQLiteDatabase bd = this.getWritableDatabase();
        int i = bd.delete(TABELA_PERSONAGENS, ID + " = ?", new String[]{String.valueOf(personagem.getId())});
        bd.close();
        return i;
    }
}
