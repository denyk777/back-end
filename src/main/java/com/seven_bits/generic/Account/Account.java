package com.seven_bits.generic.Account;

import java.util.UUID;

/**
 * account class
 */
public class Account implements Comparable<Account> {
    private String id;
    private long balance;

    /**
     *
     * @param balance balance
     */
    public Account(final long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    /**
     * throws Exception пришлось убрать иначе не срабытывал interrupt
     * @param value add value
     */
    public void addToBalance(final long value)  {
        long balance = this.balance;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.balance = balance + value;
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    /**
     *
     * @param account sent value
     * @return condition
     */
    public int compareTo(final Account account) {
        return Long.compare(this.balance, account.balance);
    }
}
