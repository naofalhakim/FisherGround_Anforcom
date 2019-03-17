package com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.BankModel;

public class Bank {
    public String nama;
    public int imgBank;


    public Bank(String nama, int imgBank) {
        this.nama = nama;
        this.imgBank = imgBank;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getImgBank() {
        return imgBank;
    }

    public void setImgBank(int imgBank) {
        this.imgBank = imgBank;
    }
}
