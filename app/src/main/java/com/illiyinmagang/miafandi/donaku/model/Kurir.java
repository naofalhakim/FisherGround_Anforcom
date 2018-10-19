package com.illiyinmagang.miafandi.donaku.model;

/**
 * Created by user on 18/10/2018.
 */

public class Kurir {
    private int Id;
    private int jenis_jasa_kirim, harga, hp;
    private String alamat;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getJenis_jasa_kirim() {
        return jenis_jasa_kirim;
    }

    public void setJenis_jasa_kirim(int jenis_jasa_kirim) {
        this.jenis_jasa_kirim = jenis_jasa_kirim;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Kurir(int id, int jenis_jasa_kirim, int harga, int hp, String alamat) {

        Id = id;
        this.jenis_jasa_kirim = jenis_jasa_kirim;
        this.harga = harga;
        this.hp = hp;
        this.alamat = alamat;
    }
}
