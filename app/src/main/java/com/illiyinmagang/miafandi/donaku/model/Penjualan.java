package com.illiyinmagang.miafandi.donaku.model;

/**
 * Created by user on 07/10/2018.
 */

public class Penjualan {
    private int id;
    private String nama;
    private String pesanan;
    private String ktp;
    private int img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPesanan() {
        return pesanan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Penjualan(String nama, String pesanan, String ktp, int img) {

        this.nama = nama;
        this.pesanan = pesanan;
        this.ktp = ktp;
        this.img = img;
    }

    public Penjualan(int id, String nama, String pesanan, String ktp, int img) {

        this.id = id;
        this.nama = nama;
        this.pesanan = pesanan;
        this.ktp = ktp;
        this.img = img;
    }
}
