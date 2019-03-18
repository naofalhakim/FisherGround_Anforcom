package com.illiyinmagang.miafandi.donaku.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by user on 02/10/2018.
 */

public class IkanJual extends RealmObject{
    @PrimaryKey
    private int id;
    private String nama;
    private String email;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IkanJual() {
    }

    public String getKeterangan() {

        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    private String keterangan, gmb;

    public String getGmb() {
        return gmb;
    }

    public void setGmb(String gmb) {
        this.gmb = gmb;
    }

    private long harga, hargasblm, hargassd;
    private int image, sign, quota;

    public IkanJual(int id, String nama, long harga, long hargasblm, long hargassd, int image, int quota) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.hargasblm = hargasblm;
        this.hargassd = hargassd;
        this.image = image;
        this.quota = quota;
    }

    public IkanJual(int id, String nama, long harga, long hargasblm, long hargassd, int image) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.hargasblm = hargasblm;
        this.hargassd = hargassd;
        this.image = image;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public IkanJual(String nama, long harga, long hargasblm, long hargassd, int image, int sign, int quota) {

        this.nama = nama;
        this.harga = harga;
        this.hargasblm = hargasblm;
        this.hargassd = hargassd;
        this.image = image;
        this.sign = sign;
        this.quota = quota;
    }

    public IkanJual(int id, String nama, long harga, long hargasblm, long hargassd, int image, int sign, int quota) {

        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.hargasblm = hargasblm;
        this.hargassd = hargassd;
        this.image = image;
        this.sign = sign;
        this.quota = quota;
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
