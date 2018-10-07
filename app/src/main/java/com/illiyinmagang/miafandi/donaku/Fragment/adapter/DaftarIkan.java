package com.illiyinmagang.miafandi.donaku.Fragment.adapter;

/**
 * Created by MIAfandi on 28/08/2017.
 */

public class DaftarIkan {
    private String namaIkan;
    private int imgIkan;
    private int hargaIkan;
    private int stock;

    public DaftarIkan(String namaIkan, int imgIkan, int hargaIkan, int stock) {
        this.namaIkan = namaIkan;
        this.imgIkan = imgIkan;
        this.hargaIkan = hargaIkan;
        this.stock = stock;
    }

    public String getNamaIkan() {
        return namaIkan;
    }

    public void setNamaIkan(String namaIkan) {
        this.namaIkan = namaIkan;
    }

    public int getImgIkan() {
        return imgIkan;
    }

    public void setImgIkan(int imgIkan) {
        this.imgIkan = imgIkan;
    }

    public int getHargaIkan() {
        return hargaIkan;
    }

    public void setHargaIkan(int hargaIkan) {
        this.hargaIkan = hargaIkan;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
