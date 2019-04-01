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


}
