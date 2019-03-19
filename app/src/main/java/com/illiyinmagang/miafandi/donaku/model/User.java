package com.illiyinmagang.miafandi.donaku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 18/10/2018.
 */

public class User {

    @Expose
    @SerializedName("email")private String username;
    @Expose
    @SerializedName("password")private String passeword;
    @Expose
    @SerializedName("telp")private String notelp;
    @Expose
    @SerializedName("status")private String status;

    public User() {
    }

    private int id;
    private String ktp, nama, alamat, foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public User(String ktp, String nama, String notelp, String username, String passeword, String alamat, String foto) {
        this.ktp = ktp;
        this.nama = nama;
        this.notelp = notelp;
        this.username = username;
        this.passeword = passeword;
        this.alamat = alamat;
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
