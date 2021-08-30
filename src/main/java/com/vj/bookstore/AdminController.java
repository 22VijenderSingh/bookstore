package com.vj.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private Admin admin;

    @RequestMapping(path = "/addCustomer", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {

        return admin.addCustomer(customer.getCustomerName(), customer.getCustomerEmail());

    }

    @RequestMapping(path = "/getCustomer", method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam int customerId) {

        return admin.getCustomerById(customerId);

    }

    @RequestMapping(path = "/addSeller", method = RequestMethod.POST)
    public Seller addSeller(@RequestBody Seller seller) {
        return admin.addSeller(seller.getSellerName(), seller.getSellerEmail());
    }

    @RequestMapping(path = "/getSeller", method = RequestMethod.GET)
    public Seller getSeller(@RequestParam int sellerId) {
        return admin.getSellerByID(sellerId);
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {

        return admin.addBook(book.getSellerId(), book.getBookName(), book.getBookPrice());
    }

    @RequestMapping(path = "/getBook", method = RequestMethod.GET)
    public Book getBook(@RequestParam int bookId) {
        return admin.getBookById(bookId);
    }

    @RequestMapping(path = "/getPurchasedBook", method = RequestMethod.GET)
    public List<Book> getPurchasedBook(@RequestParam int customerId) {
        return admin.getPurchasedBooks(customerId);
    }

    @RequestMapping(path = "/showAllBooks", method = RequestMethod.GET)
    public List<Book> showAllBooks() {
        return admin.showBooks();
    }

    @RequestMapping(path = "/searchBooks", method = RequestMethod.GET)
    public List<Book> searchBooks(@RequestParam String bookName) {
        return admin.showBookByName(bookName);
    }
//Integer
    @RequestMapping(path = "/purchaseBook", method = RequestMethod.POST)
    public boolean purchaseBook(@RequestParam int customerId, @RequestParam Integer bookId) {
        return admin.purchaseBook(customerId, bookId);
    }

    @RequestMapping(path = "/deleteBook", method = RequestMethod.DELETE)
    public void deleteBook(@RequestParam int sellerId, @RequestParam int bookId) {
        admin.deleteBook(sellerId, bookId);
    }

    @RequestMapping(path = "/updateBook", method = RequestMethod.PUT)
    public void updateBook(@RequestParam int sellerId, @RequestBody Book book,@RequestParam  int bookId) {
        admin.updateBook(sellerId, book, bookId);
    }
}
