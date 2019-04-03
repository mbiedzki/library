package pl.coderslab.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getBooks(HttpServletResponse response) {
        response.setContentType("application/json");
        return  bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id, HttpServletResponse response) {
        response.setContentType("application/json");
        return bookService.findBookById(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Long id) {

        Book bookToBeUpdated = bookService.findBookById(id);

        if(bookToBeUpdated==null) {
            bookService.saveBook(book);
        } else {
            book.setId(id);
            bookService.saveBook(book);
        }

    }

    @PostMapping("/")
    public void newBook(@RequestBody Book newBook) {
        bookService.saveBook(newBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable Long id) {
        bookService.deleteBook(id);
    }



}
