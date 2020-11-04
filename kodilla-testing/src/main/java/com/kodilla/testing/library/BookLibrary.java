package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    private final LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment){
        final List<Book> bookList = new ArrayList<>();
        Book book = new Book("Title", "Authoe", 1993);
        bookList.add(book);

        //temporary returning list of one book
        return bookList;
    }
}
