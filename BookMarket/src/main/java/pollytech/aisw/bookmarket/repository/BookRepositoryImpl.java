package pollytech.aisw.bookmarket.repository;

import org.springframework.stereotype.Repository;
import pollytech.aisw.bookmarket.domain.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class BookRepositoryImpl implements BookRepository{
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookId("hp001");
        book1.setName("해리포터와 마법사의 돌");
        book1.setDescription("런던의 호그와트 마법학교에 입학한 마법사 소년 해리 포터. 그 앞에 신비로운 모험이 펼쳐진다. " +
                "마법의 세계에서 벌어지는 흥미진진한 이야기와 우정, 그리고 사랑을 다룬 판타지 소설의 명작입니다.");
        book1.setPublisher("문학수첩");
        book1.setCategory("판타지");
        book1.setAuthor("조앤 K. 롤링");
        book1.setUnitPrice(new BigDecimal(13800));
        book1.setReleaseDate("2001/03/20");

        Book book2 = new Book();
        book2.setBookId("hp002");
        book2.setName("해리포터와 비밀의 방");
        book2.setDescription("2학년 해리포터를 기다리는 것은 또 다른 미스터리. 호그와트 학교에서 벌어지는 기묘한 사건들. " +
                "학생들이 돌처럼 굳어지는 사건이 발생하고, 그 뒤에는 어떤 검은 비밀이 숨어 있을까요?");
        book2.setPublisher("문학수첩");
        book2.setCategory("판타지");
        book2.setAuthor("조앤 K. 롤링");
        book2.setUnitPrice(new BigDecimal(13800));
        book2.setReleaseDate("2001/07/02");

        Book book3 = new Book();
        book3.setBookId("hp003");
        book3.setName("해리포터와 아즈카반의 죄수");
        book3.setDescription("3학년, 해리포터에게 가장 위험한 한 해가 찾아온다. 마법 감옥 아즈카반에서 탈옥한 죄수 시리우스 블랙. " +
                "그는 해리를 찾아 호그와트에 잠입하려 한다. 긴장감 넘치는 모험이 계속된다.");
        book3.setPublisher("문학수첩");
        book3.setCategory("판타지");
        book3.setAuthor("조앤 K. 롤링");
        book3.setUnitPrice(new BigDecimal(13800));
        book3.setReleaseDate("2001/11/26");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = null;
        for (Book searchBook: listOfBooks){
            if (searchBook != null && searchBook.getBookId() != null && searchBook.getBookId().equals(bookId)){
                book = searchBook;
                break;
            }
        }

        if (book == null){
            throw new IllegalArgumentException("도서ID가 " + bookId + "인 도서는 찾을 수가 없습니다.");
        }

        return book;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<Book>();
        for (Book searchBook : listOfBooks){
            if (category.equalsIgnoreCase(searchBook.getCategory()))
                booksByCategory.add(searchBook);
        }

        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if (booksByFilter.contains("publisher")) {
            for (String publisherName : filter.get("publisher")) {
                for (Book searchBook : listOfBooks) {
                    if (publisherName.equalsIgnoreCase(searchBook.getPublisher()))
                        booksByPublisher.add(searchBook);
                }
            }
        }

        if (booksByFilter.contains("category")) {
            for (String category : filter.get("category")) {
                List<Book> list = getBookListByCategory(category);
                booksByCategory.addAll(list);
            }
        }

        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }
}
