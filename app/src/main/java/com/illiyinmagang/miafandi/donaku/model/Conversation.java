package com.illiyinmagang.miafandi.donaku.model;

public class Conversation {
    private String name, lastChat, time;
    private int id, image;

    public Conversation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastChat() {
        return lastChat;
    }

    public void setLastChat(String lastChat) {
        this.lastChat = lastChat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Conversation(String name, String lastChat, String time, int image) {
        this.name = name;
        this.lastChat = lastChat;
        this.time = time;
        this.image = image;
    }

    public Conversation(String name, String lastChat, String time, int id, int image) {
        this.name = name;
        this.lastChat = lastChat;
        this.time = time;
        this.id = id;
        this.image = image;
    }
}
