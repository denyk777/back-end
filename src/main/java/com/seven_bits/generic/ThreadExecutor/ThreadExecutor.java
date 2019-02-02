package com.seven_bits.generic.ThreadExecutor;

import com.seven_bits.generic.Account.Account;

/**
 * thread class
 */
public class ThreadExecutor extends Thread {
    private static final int FIRST_THREAD_ADD_VALUE = 1;
    private static final int SECOND_THREAD_ADD_VALUE = 2;
    private static final int THIRD_THREAD_ADD_VALUE = -2;

    private static final int WAITING_END_THREAD = 10;

    Account account = new Account(0);
    /**
     *
     * @param millis thread sleep
     */
    public void showAccountFilling(final long millis) {
        Thread thread1 = new Thread(createTask(FIRST_THREAD_ADD_VALUE));
        Thread thread2 = new Thread(createTask(SECOND_THREAD_ADD_VALUE));
        Thread thread3 = new Thread(createTask(THIRD_THREAD_ADD_VALUE));

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(WAITING_END_THREAD);
            System.out.println("I'm sleep " + millis + " milliseconds");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        while (thread1.isAlive() && thread2.isAlive() && thread3.isAlive()) {
            try {
                Thread.sleep(WAITING_END_THREAD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(account.toString());
    }

    /**
     * create task for thread
     * @param value add for balance
     * @return runnable task
     */
    private Runnable createTask(final int value) {
        return () -> {
            System.out.println(Thread.currentThread().getName() + " start to work");
            while (!Thread.currentThread().isInterrupted()) {
                this.account.addToBalance(value);
            }
            System.out.println(Thread.currentThread().getName() + " finish work");
        };
    }
}
