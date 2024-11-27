package bg.thereadingroom.web;

import bg.thereadingroom.model.db.BookEntity;
import bg.thereadingroom.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
@Tag(name = "Books", description = "Book management APIs")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @Operation(summary = "Add a new book")
    public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {
        BookEntity savedBook = bookService.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all books")
    public ResponseEntity<Void> getBooks() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
