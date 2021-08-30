package com.vj.bookstore.models;

import java.util.ArrayList;

public class Seller {

    private String sellerName;
    private String sellerEmail;
    private int sellerId;
    private ArrayList<Book> booksSold = new ArrayList<>();
    private ArrayList<Book> booksOnSite = new ArrayList<>();
    private static int i = 1;

    public Seller(String name, String email) {
        sellerName = name;
        sellerEmail = email;
        sellerId = i;
        i++;
        System.out.println("Please Remember that your sellerId is " + sellerId);
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public ArrayList<Book> getBooksSold() {
        return booksSold;
    }

    public void setBooksSold(ArrayList<Book> booksSold) {
        this.booksSold = booksSold;
    }

    public ArrayList<Book> getBooksOnSite() {
        return booksOnSite;
    }

    public void setBooksOnSite(ArrayList<Book> booksOnSite) {
        this.booksOnSite = booksOnSite;
    }

    
    public boolean sellerCheck(String name, int id) {
        return sellerName.equals(name) && sellerId == id;
    }

    public void addBookDetail(Book book) {
        booksOnSite.add(book);
    }


}

