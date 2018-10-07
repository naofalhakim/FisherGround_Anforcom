package com.illiyinmagang.miafandi.donaku.model;

/**
 * Created by user on 06/10/2018.
 */

public class Pesan {
    private int id, idPercakapan;
    private String msg, time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPercakapan() {
        return idPercakapan;
    }

    public void setIdPercakapan(int idPercakapan) {
        this.idPercakapan = idPercakapan;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Pesan(int idPercakapan, String msg, String time) {

        this.idPercakapan = idPercakapan;
        this.msg = msg;
        this.time = time;
    }

    public Pesan(int id, int idPercakapan, String msg, String time) {

        this.id = id;
        this.idPercakapan = idPercakapan;
        this.msg = msg;
        this.time = time;
    }
}

