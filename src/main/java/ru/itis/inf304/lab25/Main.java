package ru.itis.inf304.lab25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 8, 14, 15, 26, 30}; // *Целочисленный отсортированный массив*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int element;
        try {
            element = Integer.parseInt(bufferedReader.readLine());
            CheckInput.checkInput(element, array);
        } catch (NumberUnderZeroException | IOException | NumberLessLeastException e) {
            throw new RuntimeException(e);
        }

        int result = array[0]; // Стоит ли добавить проверку, связанную с максимальным числом? (чтобы не проходить весь цикл)
        // Т.к. мы знаем максимальное число в массиве это кажется выгодным решением для производительности
        for (int i = 1; i < array.length && array[i] < element; i++) {
            result = array[i];
        }
        System.out.println(result);
    }
}