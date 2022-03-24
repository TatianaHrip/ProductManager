package ru.netology.domain;

public class Smartphone extends Product {
    private String made;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String made) {
        super(id, name, price);
        this.made = made;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }
}