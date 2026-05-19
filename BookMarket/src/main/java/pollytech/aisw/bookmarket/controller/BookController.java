package pollytech.aisw.bookmarket.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pollytech.aisw.bookmarket.domain.Book;
import pollytech.aisw.bookmarket.service.BookService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Value("${file.uploadDir}")
    String fileDir;

    @GetMapping
    public String requestBookList(Model model) {
        List<Book> listOfBooks = bookService.getAllBookList();
        model.addAttribute("bookList", listOfBooks);
        return "books";
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        model.addAttribute("bookList", booksByCategory);
        return "books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model) {
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books";
    }

    @GetMapping("/add")
    public String requestAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String submitAddNewBook(@ModelAttribute Book book) {
        MultipartFile bookImage = book.getBookImage();
        String saveName = null;

        if (bookImage != null && !bookImage.isEmpty()) {
            saveName = bookImage.getOriginalFilename();
            File saveFile = new File(fileDir, saveName);
            try {
                bookImage.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException("파일 저장 중 오류가 발생했습니다.", e);
            }
        }

        book.setFileName(saveName);
        bookService.setNewBook(book);
        return "redirect:/books";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("addTitle", "새로운 마법 도서 등록");
    }

    @GetMapping("/download")
    public void downloadBookImage(@RequestParam("file") String fileName, HttpServletResponse response) {
        File imgFile = new File(fileDir, fileName);

        response.setContentType("application/download");
        response.setContentLength((int) imgFile.length());
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

        try (FileInputStream fileIn = new FileInputStream(imgFile);
             OutputStream out = response.getOutputStream()) {
            FileCopyUtils.copy(fileIn, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/all")
    public ModelAndView requestAllBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> list = bookService.getAllBookList();
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");
        return modelAndView;
    }
}
