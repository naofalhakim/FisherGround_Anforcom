package com.illiyinmagang.miafandi.donaku.model.TempModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.illiyinmagang.miafandi.donaku.model.Penjualan;

import java.util.List;

public class TempPermintaan {
    @Expose
    @SerializedName("user")private List<Penjualan> users;
    @Expose
    @SerializedName("success")private String sukses;
    @Expose
    @SerializedName("message")private String messaage;

    public List<Penjualan> getUsers() {
        return users;
    }

    public void setUsers(List<Penjualan> users) {
        this.users = users;
    }

    public String getSukses() {
        return sukses;
    }

    public void setSukses(String sukses) {
        this.sukses = sukses;
    }

    public String getMessaage() {
        return messaage;
    }

    public void setMessaage(String messaage) {
        this.messaage = messaage;
    }
}
