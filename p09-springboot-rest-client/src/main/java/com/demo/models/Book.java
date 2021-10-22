package com.demo.models;

public class Book {
    
    private int id;
	private double price;
	private String title;
	private String author;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(int id, double price, String title, String author) {
        this(price, title, author);
        this.id = id;
    }
    public Book(double price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", price='" + getPrice() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            "}";
    }

}
