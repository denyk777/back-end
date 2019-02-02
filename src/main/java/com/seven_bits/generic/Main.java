package com.seven_bits.generic;

import com.seven_bits.generic.Account.Account;
import com.seven_bits.generic.ListOperator.ListOperator;
import com.seven_bits.generic.ThreadExecutor.ThreadExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * main class
 */
public final class Main {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    private static final int START_INTEGER_RANGE = 0;
    private static final int FINISH_INTEGER_RANGE = 3;
    private static final int START_ACCOUNT_RANGE = 0;
    private static final int FINISH_ACCOUNT_RANGE = 2;
    private static final int FIRST_CHANGE_FIELD = 1;
    private static final int SECOND_CHANGE_FIELD = 3;

    private static final int TIME_SLEEP_THREAD = 2000;

    private Main() {
    }

    /**
     *
     * @param args arguments
     */
    public static void main(final String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(THREE);
        numbers.add(FOUR);
        numbers.add(TWO);
        numbers.add(ONE);

        ListOperator<Integer> listOperator = new ListOperator<>();
        Integer maxNumber = listOperator.max(numbers, START_INTEGER_RANGE, FINISH_INTEGER_RANGE);
        System.out.println("Maximum number " + maxNumber);

        List<Account> accounts = new LinkedList<>();
        accounts.add(new Account(TWO));
        accounts.add(new Account(ONE));
        accounts.add(new Account(FOUR));
        accounts.add(new Account(THREE));

        ListOperator<Account> accountListOperator = new ListOperator<>();
        Account maxBalance = accountListOperator.max(accounts, START_ACCOUNT_RANGE, FINISH_ACCOUNT_RANGE);
        System.out.println("Account with maximum balance in range " + START_ACCOUNT_RANGE + "-" +
                FINISH_ACCOUNT_RANGE + " it " + maxBalance + "\n");

        accountListOperator.changeElementsPosition(accounts, FIRST_CHANGE_FIELD, SECOND_CHANGE_FIELD);
        accountListOperator.printList(accounts);

        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.showAccountFilling(TIME_SLEEP_THREAD);
    }
}
