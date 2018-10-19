package com.illiyinmagang.miafandi.donaku.model;

public class Investasi {
    private int idInvestasi;
    private String tanggal_tutup, keterangan, dana;

    public int getIdInvestasi() {
        return idInvestasi;
    }

    public void setIdInvestasi(int idInvestasi) {
        this.idInvestasi = idInvestasi;
    }

    public String getTanggal_tutup() {
        return tanggal_tutup;
    }

    public void setTanggal_tutup(String tanggal_tutup) {
        this.tanggal_tutup = tanggal_tutup;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getDana() {
        return dana;
    }

    public void setDana(String dana) {
        this.dana = dana;
    }

    public Investasi(int idInvestasi, String tanggal_tutup, String keterangan, String dana) {

        this.idInvestasi = idInvestasi;
        this.tanggal_tutup = tanggal_tutup;
        this.keterangan = keterangan;
        this.dana = dana;
    }
}
