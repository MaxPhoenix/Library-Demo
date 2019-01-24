package com.bookstore.daos.Book;

import com.bookstore.config.PropertiesConfig;
import com.bookstore.daos.BaseDAO;
import com.bookstore.model.Book.Book;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends BaseDAO {

    public BookDAO(){
        super();
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO " + BOOK_SCHEME + "Book " +
                     "(title, author, price )" +
                     "VALUES (?,?,?)";
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setBigDecimal(3, book.getPrice());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();
    }

    public void removeBook(int bookId) throws SQLException {
        String sql = "DELETE FROM" + BOOK_SCHEME + "Book AS  b" +
                     "WHERE b.book_id = ?";
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1,bookId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE FROM" + BOOK_SCHEME + "Book " +
                     "SET title = ? "+
                     "SET author = ? "+
                     "SET price = ? "+
                     "WHERE b.book_id = ?";
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setBigDecimal(3, book.getPrice());
        preparedStatement.setInt(4, book.getBookId());

        preparedStatement.executeUpdate();

        stmt.close();
        conn.close();
    }

    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book();

        String sql = "SELECT book_id, title, author, price FROM" + BOOK_SCHEME + "Book AS  b";

        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        stmt = conn.createStatement();

        rs = stmt.executeQuery(sql);

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            BigDecimal price = rs.getBigDecimal("price");

            book = new Book();
            book.setBookId(bookId);
            book.setAuthor(author);
            book.setTitle(title);
            book.setPrice(price);

            books.add(book);
        }

        rs.close();
        stmt.close();
        conn.close();

        return books;
    }

    public Book getBookById(int id) throws SQLException {
        Book book = new Book();

        String sql = "SELECT book_id, title, author, price FROM" + BOOK_SCHEME + "Book AS  b WHERE book_id = " + id;

        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        stmt = conn.createStatement();

        rs = stmt.executeQuery(sql);

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            BigDecimal price = rs.getBigDecimal("price");

            book = new Book();
            book.setBookId(bookId);
            book.setAuthor(author);
            book.setTitle(title);
            book.setPrice(price);
        }

        rs.close();
        stmt.close();
        conn.close();

        return book;
    }
}
