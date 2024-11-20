package bg.thereadingroom.service;

import bg.thereadingroom.model.db.BookEntity;

public interface BookService {

    BookEntity save(BookEntity book);
}
