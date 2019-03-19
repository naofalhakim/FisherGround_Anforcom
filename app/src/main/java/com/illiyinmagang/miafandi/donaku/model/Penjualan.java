package com.illiyinmagang.miafandi.donaku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 07/10/2018.
 */

public class Penjualan {

    @Expose
    @SerializedName("nama_pembeli")private String nama;
    @Expose
    @SerializedName("alamat")private String alamat;
    @Expose
    @SerializedName("telp")private String notelp;
    @Expose
    @SerializedName("nama_ikan")private String pesanan;
    @Expose
    @SerializedName("berat")private int weight;
    @Expose
    @SerializedName("jasa_pengiriman")private String jasa_pengiriman;
    @Expose
    @SerializedName("tanggal_kirim")private String tanggal_kirim;

    private int id;
    private String ktp;
    private int img;

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getJasa_pengiriman() {
        return jasa_pengiriman;
    }

    public void setJasa_pengiriman(String jasa_pengiriman) {
        this.jasa_pengiriman = jasa_pengiriman;
    }

    public String getTanggal_kirim() {
        return tanggal_kirim;
    }

    public void setTanggal_kirim(String tanggal_kirim) {
        this.tanggal_kirim = tanggal_kirim;
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

    public String getPesanan() {
        return pesanan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Penjualan(String nama, String alamat, String pesanan, String ktp, int img, int weight) {
        this.nama = nama;
        this.alamat = alamat;
        this.pesanan = pesanan;
        this.ktp = ktp;
        this.img = img;
        this.weight = weight;
    }

    public Penjualan(int id, String nama, String alamat, String pesanan, String notelp, int img, int weight) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.pesanan = pesanan;
        this.notelp = notelp;
        this.img = img;
        this.weight = weight;
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
