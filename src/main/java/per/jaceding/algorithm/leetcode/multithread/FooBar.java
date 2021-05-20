package per.jaceding.algorithm.leetcode.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jaceding
 * @date 2020/9/30
 */
public class FooBar {

    private volatile int state = 1;
    private Lock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 1) {
                conditionWait(fooCondition);
            }
            printFoo.run();
            state = 2;
            conditionSignal(barCondition);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 2) {
                conditionWait(barCondition);
            }
            printBar.run();
            state = 1;
            conditionSignal(fooCondition);
        }
    }

    public void conditionWait(Condition condition) {
        lock.lock();
        try {
            condition.await();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal(Condition condition) {
        lock.lock();
        try {
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
