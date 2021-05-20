package per.jaceding.algorithm.leetcode.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author jaceding
 * @date 2020/9/30
 */
public class FizzBuzz {

    private Lock lock = new ReentrantLock();
    private Condition fizzCondition = lock.newCondition();
    private Condition buzzCondition = lock.newCondition();
    private Condition fizzbuzzCondition = lock.newCondition();
    private Condition numberCondition = lock.newCondition();

    private volatile int state = 1;

    private AtomicInteger num = new AtomicInteger(1);

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (; num.get() <= n; ) {
            while (state != 2 && num.get() <= n) {
                conditionWait(fizzCondition);
            }
            if (num.get() <= n) {
                printFizz.run();
                num.incrementAndGet();
                doSignal();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (; num.get() <= n; ) {
            while (state != 3 && num.get() <= n) {
                conditionWait(buzzCondition);
            }
            if (num.get() <= n) {
                printBuzz.run();
                num.incrementAndGet();
                doSignal();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (; num.get() <= n; ) {
            while (state != 4 && num.get() <= n) {
                conditionWait(fizzbuzzCondition);
            }
            if (num.get() <= n) {
                printFizzBuzz.run();
                num.incrementAndGet();
                doSignal();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (; num.get() <= n; ) {
            while (state != 1 && num.get() <= n) {
                conditionWait(numberCondition);
            }
            if (num.get() <= n) {
                printNumber.accept(num.get());
                num.incrementAndGet();
                doSignal();
            }
        }
    }

    private void doSignalAll() {
        conditionSignal(fizzbuzzCondition);
        conditionSignal(fizzCondition);
        conditionSignal(buzzCondition);
        conditionSignal(numberCondition);
    }

    private void doSignal() {
        if (num.get() <= n) {
            System.out.printf(",");
            if (num.get() % 3 == 0) {
                if (num.get() % 5 == 0) {
                    state = 4;
                    conditionSignal(fizzbuzzCondition);
                } else {
                    state = 2;
                    conditionSignal(fizzCondition);
                }
            } else if (num.get() % 5 == 0) {
                state = 3;
                conditionSignal(buzzCondition);
            } else {
                state = 1;
                conditionSignal(numberCondition);
            }
        } else {
            doSignalAll();
        }
    }

    private void conditionWait(Condition condition) {
        lock.lock();
        try {
            condition.await();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    private void conditionSignal(Condition condition) {
        lock.lock();
        try {
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable fizzRunable = () -> System.out.printf("fizz");
        Runnable buzzRunable = () -> System.out.printf("buzz");
        Runnable fizzbuzzRunable = () -> System.out.printf("fizzbuzz");
        IntConsumer intConsumer = (e) -> System.out.printf(String.valueOf(e));
        new Thread(() -> {
            try {
                fizzBuzz.fizz(fizzRunable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.buzz(buzzRunable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(fizzbuzzRunable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
