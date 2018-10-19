package com.illiyinmagang.miafandi.donaku.model;

/**
 * Created by user on 18/10/2018.
 */

public class Ikan {
    private int idJual;
    private int stock, harga, nama_ikan, gambar, keterangan;

    public int getIdJual() {
        return idJual;
    }

    public void setIdJual(int idJual) {
        this.idJual = idJual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getNama_ikan() {
        return nama_ikan;
    }

    public void setNama_ikan(int nama_ikan) {
        this.nama_ikan = nama_ikan;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(int keterangan) {
        this.keterangan = keterangan;
    }

    public Ikan(int idJual, int stock, int harga, int nama_ikan, int gambar, int keterangan) {

        this.idJual = idJual;
        this.stock = stock;
        this.harga = harga;
        this.nama_ikan = nama_ikan;
        this.gambar = gambar;
        this.keterangan = keterangan;
    }
}
