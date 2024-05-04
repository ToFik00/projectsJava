package ru.itis.inf304;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.inf304.lab33_threads.SingletonTesting.Singletone;

public class SingletoneTest {

    @Test
    public void singletonePatternTest() {
        Singletone singletone1 = Singletone.getInstance();
        Singletone singletone2 = Singletone.getInstance();
        Assert.assertSame(singletone1, singletone2);
    }
}
