package ru.itis.inf304;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.MalformedInputException;

import static ru.itis.inf304.lab32_junit.OwnJsonReader.isCorrectBrackets;

public class OwnJsonReaderTest {

    @Test
    public void isCorrectBracketsTest() {
        Assert.assertEquals(isCorrectBrackets("fileExampleJson_1.json"), 1);
        Assert.assertEquals(isCorrectBrackets("fileExampleJson_0.json"), 0);
        // Корректность работы

        Assert.assertThrows(NullPointerException.class,
                () -> isCorrectBrackets(""));
        // NullPointer если передали пустое имя файла

        try {
            isCorrectBrackets("какой-то несуществующий файл");
            Assert.fail();
        }
        catch (RuntimeException ex) {
            Assert.assertEquals(FileNotFoundException.class, ex.getCause().getClass());
            // Исключение, если файл не найден
        }

        try {
            isCorrectBrackets("output-onlinefiletools.bin");
            Assert.fail();
        }
        catch (RuntimeException ex) {
            /*if (ex.getCause() instanceof CharacterCodingException) Assert.assertTrue(true);
            else Assert.fail();*/
            Assert.assertEquals(MalformedInputException.class, ex.getCause().getClass());
            // Исключение, если файл не текстовый (проверка на буквы, цифры, знаки препинания)
        }


        /*Assert.assertThrows(FileNotFoundException.class,
                () -> isCorrectBrackets("какой-то несуществующий файл"));
        Assert.assertThrows(CharacterCodingException.class,
                () -> isCorrectBrackets("fileBinary1"));*/
    }
}
