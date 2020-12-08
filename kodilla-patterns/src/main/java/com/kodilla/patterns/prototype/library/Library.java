package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepClone(String name) throws CloneNotSupportedException {
        Library cloneLibrary = super.clone();
        cloneLibrary.setName(name);
        cloneLibrary.books = new HashSet<>();
        for (Book book : books) {
            cloneLibrary.getBooks().add(book);
        }
        return cloneLibrary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() throws NullPointerException {
        return books;
    }
}
