package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        System.out.println("Test getBooks() method and clone method test");
        //Given
        final Library library = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Book " + n, "Author " + n, LocalDate.now())));
        System.out.println(library);
        //making a shallow clone of library
        Library shallowCloneLibrary = null;
        try {
            shallowCloneLibrary = library.shallowClone();
            shallowCloneLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(shallowCloneLibrary);
        //making a deep clone of library
        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepClone("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(deepCloneLibrary);
        System.out.println(deepCloneLibrary.getBooks());
        //When
        library.getBooks().clear();
        //Then
        assertTrue(library.getBooks().isEmpty());
        assertTrue(shallowCloneLibrary.getBooks().isEmpty());
        assertEquals(10, deepCloneLibrary.getBooks().size());
        assertEquals("Library 3", deepCloneLibrary.getName());
    }
}
