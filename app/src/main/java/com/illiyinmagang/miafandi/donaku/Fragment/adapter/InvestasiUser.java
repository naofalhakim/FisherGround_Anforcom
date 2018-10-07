package com.illiyinmagang.miafandi.donaku.Fragment.adapter;

public class InvestasiUser {
    private int imgInvestasi;
    private String namaInvestasi;
    private String pembuatInvestasi;
    private String lokasiInvestasi;
    private int donaturInvestasi;
    private int roiInvestasi;
    private int biayaInvestasi;

    public InvestasiUser(int imgInvestasi,String namaInvestasi, String pembuatInvestasi, String lokasiInvestasi, int donaturInestasi, int roiInvestasi, int biayaInvestasi) {
        this.imgInvestasi = imgInvestasi;
        this.namaInvestasi = namaInvestasi;
        this.pembuatInvestasi = pembuatInvestasi;
        this.lokasiInvestasi = lokasiInvestasi;
        this.donaturInvestasi = donaturInestasi;
        this.roiInvestasi = roiInvestasi;
        this.biayaInvestasi = biayaInvestasi;
    }

    public int getImgInvestasi() {
        return imgInvestasi;
    }

    public void setImgInvestasi(int imgInvestasi) {
        this.imgInvestasi = imgInvestasi;
    }

    public String getNamaInvestasi() {
        return namaInvestasi;
    }

    public void setNamaInvestasi(String namaInvestasi) {
        this.namaInvestasi = namaInvestasi;
    }

    public String getPembuatInvestasi() {
        return pembuatInvestasi;
    }

    public void setPembuatInvestasi(String pembuatInvestasi) {
        this.pembuatInvestasi = pembuatInvestasi;
    }

    public String getLokasiInvestasi() {
        return lokasiInvestasi;
    }

    public void setLokasiInvestasi(String lokasiInvestasi) {
        this.lokasiInvestasi = lokasiInvestasi;
    }

    public int getDonaturInvestasi() {
        return donaturInvestasi;
    }

    public void setDonaturInvestasi(int donaturInvestasi) {
        this.donaturInvestasi = donaturInvestasi;
    }

    public int getRoiInvestasi() {
        return roiInvestasi;
    }

    public void setRoiInvestasi(int roiInvestasi) {
        this.roiInvestasi = roiInvestasi;
    }

    public int getBiayaInvestasi() {
        return biayaInvestasi;
    }

    public void setBiayaInvestasi(int biayaInvestasi) {
        this.biayaInvestasi = biayaInvestasi;
    }
}
