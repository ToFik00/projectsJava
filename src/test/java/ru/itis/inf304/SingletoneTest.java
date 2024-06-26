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

    @Test
    public void singletonePatternTestThreads() {
        for (int i = 0; i < 100; i++) {
            ThreadSingletoneTester thread1 = new ThreadSingletoneTester();
            ThreadSingletoneTester thread2 = new ThreadSingletoneTester();
            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Assert.assertSame(thread1.getSingletone(), thread2.getSingletone());
        }
    }
}
