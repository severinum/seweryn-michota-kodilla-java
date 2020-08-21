package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTestSuite {


    @Test
    void testReadFile(){
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void whenFileDosentExistsReadFileShouldThrowException(){
        // given
        FileReader fileReader = new FileReader();
        String filenName = "file_not_exists.txt";
        // when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(filenName));
    }

    @Test
    public void testReadFileWithName() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }


}







