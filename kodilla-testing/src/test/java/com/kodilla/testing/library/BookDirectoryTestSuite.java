package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private int testCounter = 0;

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Alle tests are finished");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + 1, "Author" + 1, 1950 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Nested
    @DisplayName("listBooksWithCondition() method tests")
    class TestListBooksWithCondition {

        @Test
        void testListBooksWithConditionReturnList() {
            System.out.println("Test List Books With Condition Return List");
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
            //When
            List<Book> theListOfBook = bookLibrary.listBooksWithCondition("Secret");
            //Then
            assertEquals(4, theListOfBook.size());
        }

        @Test
        void testListBooksWithConditionMoreThen20() {
            System.out.println("Test List Books With Condition More Then 20");
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
            //When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            //Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());

        }

        @Test
        void testBooksWithConditionFragmentShorterThen3() {
            System.out.println("Test Books With Condition Fragment Shorter Then 3");
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf10Books = generateListOfNBooks(10);
            //when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
            //When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
            //Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, never()).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("listBooksInHandsOf() method tests")
    class TestListBooksInHandsOf {

        @Test
        void testNoBooksInHandsOf() {
            System.out.println("Test No Books In Hands Of");
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("John", "Smith", 1234567890);
            List<Book> resultListOf0Books = new ArrayList<>();

            //When
            //Then
        }

        @Test
        void testOneBooksInHandsOf() {
            //Given
            //When
            //Then
        }

        @Test
        void testFiveBooksInHandsOf() {
            //Given
            //When
            //Then
        }
    }
}
