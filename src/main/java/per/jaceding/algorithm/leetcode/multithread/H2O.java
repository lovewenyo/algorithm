package per.jaceding.algorithm.leetcode.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jaceding
 * @date 2020/9/30
 */
public class H2O {

    private AtomicInteger num = new AtomicInteger(0);
    private volatile int state = 1;
    private Lock lock = new ReentrantLock();
    private Condition hydrogenCondition = lock.newCondition();
    private Condition oxygenCondition = lock.newCondition();

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (state != 1) {
            conditionWait(hydrogenCondition);
        }
        releaseHydrogen.run();
        num.incrementAndGet();
        if (num.get() % 2 == 0) {
            state = 2;
            conditionSignal(oxygenCondition);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (state != 2) {
            conditionWait(oxygenCondition);
        }
        state = 1;
        releaseOxygen.run();
        conditionSignal(hydrogenCondition);
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
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        H2O h2O = new H2O();
        Runnable hydrogenRunnable = () -> System.out.printf("H");
        Runnable oxygenRunnable = () -> System.out.printf("O");
        int n = 8;
        new Thread(() -> {
            for(int i = 0;i < n; i ++){
                try {
                    h2O.hydrogen(hydrogenRunnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i = 0;i < n / 2; i ++){
                try {
                    h2O.oxygen(oxygenRunnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
