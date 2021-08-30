package com.vj.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    private String bookName;
    private int bookId;
    private Integer bookPrice;
    private static int i = 1;
    private Integer sellerId;
    private Integer customerId;
    private boolean bookSold;

    public Book() {
    }

    public Book(Integer sellerId, String bookName, Integer bookPrice) {
        this.bookId = i++;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.sellerId = sellerId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public boolean isBookSold() {
        return bookSold;
    }

    public void setBookSold(boolean bookSold) {
        this.bookSold = bookSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                bookPrice.equals(book.bookPrice) &&
                sellerId.equals(book.sellerId) &&
                customerId.equals(book.customerId) &&
                bookSold == book.bookSold &&
                bookName.equals(book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookId, bookPrice, sellerId, customerId, bookSold);
    }
}
