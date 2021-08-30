package com.vj.bookstore.service;

import com.vj.bookstore.exception.BookstoreServiceException;
import com.vj.bookstore.models.Book;
import com.vj.bookstore.models.Customer;
import com.vj.bookstore.models.Seller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Admin {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public Seller addSeller(String sellerName, String sellerEmail) {
        Seller seller = new Seller(sellerName, sellerEmail);
        sellers.add(seller);
        return seller;
    }

    public Seller getSellerByID(int sellerId) {

        for (Seller seller : sellers) {
            if (seller.getSellerId() == sellerId) {
                return seller;
            }
        }
        throw new BookstoreServiceException("Seller not found for the corresponding sellerID");
    }

    public Book addBook(Integer sellerId, String bookName, Integer bookPrice) {
        Seller seller = getSellerByID(sellerId);
        Book book = new Book(sellerId, bookName, bookPrice);
        if (seller == null) {
            return null;
        }
        seller.getBooksOnSite().add(book);
        books.add(book);
        return book;
    }

    public Customer addCustomer(String customerName, String customerEmail) {
        Customer customer = new Customer(customerName, customerEmail);
        customers.add(customer);
        return customer;
    }

    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        throw new BookstoreServiceException("Customer not found corresponding to this customerID");
    }

    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        throw new BookstoreServiceException("Book not found corresponding to this bookID");
    }

    public List<Book> showBooks() {
        return books;
    }

    public List<Book> showBookByName(String bookName) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public boolean purchaseBook(int customerId, int bookId) {
        Book book = getBookById(bookId);
        if (book.isBookSold()) {
            throw new BookstoreServiceException("Book is already sold, please search for another book");

        }
        Customer customer = getCustomerById(customerId);
        customer.getBooksBought().add(book);
        book.setBookSold(true);
        Seller seller = getSellerByID(book.getSellerId());
        seller.getBooksSold().add(book);
        seller.getBooksOnSite().remove(book);
        return true;

    }

    public List<Book> getPurchasedBooks(int customerId) {
        Customer customer = getCustomerById(customerId);
        return customer.getBooksBought();

    }

    public void deleteBook(int sellerId, int bookId) {
        Seller seller = getSellerByID(sellerId);
        Book book = getBookById(bookId);
        if (!book.isBookSold()) {
            books.remove(book);
            seller.getBooksOnSite().remove(book);
        }else{
            throw new BookstoreServiceException("Cannot delete sold books");
        }
    }

    public void updateBook(int sellerId, Book book, int bookId) {
        Book currentBook = getBookById(bookId);
        if (currentBook.isBookSold()) {
            throw new BookstoreServiceException("Not allowed to make changes to sold books");

        }
        if (book.getBookName() != null) {
            currentBook.setBookName(book.getBookName());
        }
        if (book.getBookPrice() != null) {
            currentBook.setBookPrice(book.getBookPrice());
        }

    }


}

