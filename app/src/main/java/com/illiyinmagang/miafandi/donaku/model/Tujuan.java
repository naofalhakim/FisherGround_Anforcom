package com.illiyinmagang.miafandi.donaku.model;

/**
 * Created by user on 18/10/2018.
 */

public class Tujuan {
    private String idTUjuan, kotaAsal, kotaTujuan, harga;

    public String getIdTUjuan() {
        return idTUjuan;
    }

    public void setIdTUjuan(String idTUjuan) {
        this.idTUjuan = idTUjuan;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Tujuan(String idTUjuan, String kotaAsal, String kotaTujuan, String harga) {

        this.idTUjuan = idTUjuan;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.harga = harga;
    }
}
