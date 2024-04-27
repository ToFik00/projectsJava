package ru.itis.inf304;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.inf304.lab32_junit.SmoothSort;

public class SmoothSortTest {

    @Test
    public void sortTest() {
        int[] array1 = {1, 7, 32, 8, 4, 2, 67, 9, 5, 4, 3, 1000, 2, 3, 5};
        int[] arrayExpected1 = {1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 8, 9, 32, 67, 1000};
        int[] array2 = {-5, 5, -1, 1, 2, 3, -2, -3, 4, -4};
        int[] arrayExpected2 = {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};

        new SmoothSort().sort(array1);
        new SmoothSort().sort(array2);

        Assert.assertArrayEquals(array1, arrayExpected1);
        Assert.assertArrayEquals(array2, arrayExpected2);
    }
}
