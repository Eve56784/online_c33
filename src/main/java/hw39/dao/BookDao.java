package hw39.dao;

import hw39.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from books order by id asc",
                (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price")));
    }

    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject("select * from books where id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price")));
    }

    public void addBook(Book book) {
        jdbcTemplate.update("insert into books (title, author, price) values (?,?, ?)",
                book.getTitle(), book.getAuthor(), book.getPrice());
    }

    public void updateBook(Book book) {
        jdbcTemplate.update("update books set title = ?, author = ?, price = ? where id = ?",
                book.getTitle(), book.getAuthor(), book.getPrice(), book.getId());
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("delete from books where id = ?", id);
    }
}
