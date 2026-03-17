package pollytech.aisw.bookmarket.repository;

import pollytech.aisw.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
}
