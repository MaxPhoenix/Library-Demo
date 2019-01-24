package com.bookstore.services.Book;

import com.bookstore.daos.Book.BookDAO;
import com.bookstore.model.Book.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService  {

    private BookDAO bookDAO;

    public BookService(){
        this.bookDAO = new BookDAO();
    }

    public void addBook(Book book){
        try{
            this.bookDAO.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateBook(Book book){
        try{
            this.bookDAO.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getBookById(int id){
        try {
            return this.bookDAO.getBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooks(){
        try {
            return this.bookDAO.getBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
