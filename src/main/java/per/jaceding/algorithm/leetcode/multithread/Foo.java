package per.jaceding.algorithm.leetcode.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author jaceding
 * @date 2020/9/30
 */
public class Foo {

    CountDownLatch secondCountDownLatch = new CountDownLatch(1);

    CountDownLatch thirdCountDownLatch = new CountDownLatch(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondCountDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondCountDownLatch.await();
        printSecond.run();
        thirdCountDownLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdCountDownLatch.await();
        printThird.run();
    }
}
