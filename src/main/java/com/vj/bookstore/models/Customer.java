package com.vj.bookstore.models;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private String customerEmail;
    private int customerId;
    private ArrayList<Book> booksBought = new ArrayList<>();
    private ArrayList<Book> booksCart = new ArrayList<>();
    private static int i = 1;

    public Customer(String name, String email) {
        customerName = name;
        customerEmail = email;
        customerId = i;
        i++;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public ArrayList<Book> getBooksBought() {
        return booksBought;
    }

    public void setBooksBought(ArrayList<Book> booksBought) {
        this.booksBought = booksBought;
    }

    public ArrayList<Book> getBooksCart() {
        return booksCart;
    }

    public void setBooksCart(ArrayList<Book> booksCart) {
        this.booksCart = booksCart;
    }

    public int getCustomerId() {
        return customerId;
    }
}
