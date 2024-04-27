package ru.itis.inf304.lab32_junit;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.util.Stack;

public class OwnJsonReader {

    public static int isCorrectBrackets(String fileName) { // 1 - true, 0 - false
        if (fileName == null || fileName.isEmpty()) throw new NullPointerException();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] bytes = fis.readAllBytes();
            try {
                Charset.availableCharsets().get("UTF-8").newDecoder().decode(ByteBuffer.wrap(bytes));
            } catch (MalformedInputException e) {
                throw new RuntimeException(e);
            } // Или проверять расширение файла? Т.к. по тз сказано, что данный метод для json,
            // тогда можно просто проверить расширение файла Files.probeContentType(Path.of(fileName))
            Stack<Character> stack = new Stack<>();
            for (byte by : bytes) {
                char ch = (char) by;
                if (ch == '{' || ch == '}' || ch == '[' || ch == ']') {
                    if (!stack.isEmpty() && ((stack.peek().equals('{') && ch == '}')
                            || (stack.peek().equals('[') && ch == ']')))
                        stack.pop();
                    else if (!stack.isEmpty() && ((stack.peek().equals('{') && ch == ']')
                            || (stack.peek().equals('[') && ch == '}')))
                        return 0;
                    else
                        stack.push(ch);
                }
            }
            if (stack.isEmpty())
                return 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }



    //Files.probeContentType(Path.of(fileName))
}
