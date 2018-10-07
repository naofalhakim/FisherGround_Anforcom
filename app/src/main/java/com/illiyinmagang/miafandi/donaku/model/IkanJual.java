package com.illiyinmagang.miafandi.donaku.model;

/**
 * Created by user on 02/10/2018.
 */

public class IkanJual {
    private int id;
    private String nama;
    private long harga, hargasblm, hargassd;
    private int image, sign;

    public IkanJual(int id, String nama, long harga, long hargasblm, long hargassd, int image) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.hargasblm = hargasblm;
        this.hargassd = hargassd;
        this.image = image;
    }

    public IkanJual(int id, String nama, long harga, int image) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.image = image;
    }

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

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public long getHargasblm() {
        return hargasblm;
    }

    public void setHargasblm(long hargasblm) {
        this.hargasblm = hargasblm;
    }

    public long getHargassd() {
        return hargassd;
    }

    public void setHargassd(long hargassd) {
        this.hargassd = hargassd;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
