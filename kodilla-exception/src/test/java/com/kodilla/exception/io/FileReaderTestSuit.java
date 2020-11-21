package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuit {

    @Test
    void testReadFile() {
        //Given
        final FileReader fileReader = new FileReader();
        //When & Then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void testWhenFileDoesNotExistsReadFileShouldThrowException() {
        //Given
        final FileReader fileReader = new FileReader();
        final String fileName = "wrongName.txt";
        //When & Then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @Test
    void testReadFileWithFileName() {
        //Given
        FileReader fileReader = new FileReader();
        //When & Then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("wrongName.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }
}
