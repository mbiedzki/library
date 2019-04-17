package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.BookService;
import pl.coderslab.model.Book;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getBooks(HttpServletResponse response) {
        response.setContentType("application/json");
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id, HttpServletResponse response) {
        response.setContentType("application/json");
        return bookService.findBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {

        Book bookToBeUpdated = bookService.findBookById(id);

        bookToBeUpdated.setTitle(book.getTitle());
        bookToBeUpdated.setAuthor(book.getAuthor());
        bookToBeUpdated.setCategory(book.getCategory());
        bookToBeUpdated.setFormat(book.getFormat());

        return bookService.saveBook(bookToBeUpdated);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Book newBook(@RequestBody Book newBook) {

        Book bookToBeAdded = new Book();
        bookToBeAdded.setId(null);
        bookToBeAdded.setTitle(newBook.getTitle());
        bookToBeAdded.setAuthor(newBook.getAuthor());
        bookToBeAdded.setCategory(newBook.getCategory());
        bookToBeAdded.setFormat(newBook.getFormat());
        return bookService.addBook(bookToBeAdded);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }


}
