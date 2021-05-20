package per.jaceding.algorithm.leetcode.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * "0102030405"
 *
 * @author jaceding
 * @date 2020/9/30
 */
public class ZeroEvenOdd {

    private volatile int state = 1;

    private volatile int num = 1;

    private Lock lock = new ReentrantLock();
    private Condition zeroCondition = lock.newCondition();
    private Condition noZeroCondition = lock.newCondition();

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 1) {
                conditionWait(zeroCondition);
            }
            state = 2;
            printNumber.accept(0);
            conditionSignal(noZeroCondition);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            while (num % 2 != 0 || state != 2) {
                conditionWait(noZeroCondition);
            }
            state = 1;
            printNumber.accept(num++);
            conditionSignal(zeroCondition);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < (n + 1) / 2; i++) {
            while (num % 2 == 0 || state != 2) {
                conditionWait(noZeroCondition);
            }
            state = 1;
            printNumber.accept(num++);
            conditionSignal(zeroCondition);
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
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        IntConsumer consumer = System.out::print;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
