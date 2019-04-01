package com.gneto.starwarsapi;

import android.support.annotation.IntegerRes;

public class Personagem {

    private String name;
    private float heith;
    private float mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private int birth_year;
    private String gender;
    private String nome_do_planeta_natal;
    private String nome_da_especie;
    private Integer Favorite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeith() {
        return heith;
    }

    public void setHeith(float heith) {
        this.heith = heith;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNome_do_planeta_natal() {
        return nome_do_planeta_natal;
    }

    public void setNome_do_planeta_natal(String nome_do_planeta_natal) {
        this.nome_do_planeta_natal = nome_do_planeta_natal;
    }

    public String getNome_da_especie() {
        return nome_da_especie;
    }

    public void setNome_da_especie(String nome_da_especie) {
        this.nome_da_especie = nome_da_especie;
    }

    public Integer getFavorite() {
        return Favorite;
    }

    public void setFavorite(Integer favorite) {
        Favorite = favorite;
    }

    public String toString() {
        return "Name: " + getName() + "\nAltura: " + getHeith() + "\nGênero: " + getGender() + "\nPeso: " + getMass() + "\nSeu Favorito? " + getFavorite();
    }
}