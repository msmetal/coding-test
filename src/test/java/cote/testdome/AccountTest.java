package cote.testdome;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
Using JUnit 4's Assert class, write tests for the Account class that cover the following cases:

The deposit and withdraw methods will not accept negative numbers.
Account cannot overstep its overdraft limit.
The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
The withdraw and deposit methods return the correct results.
 */

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void notAcceptNegativeNumbers() {
        Account account = new Account(0);
        assertThat(account.deposit(-100)).isFalse();
        assertThat(account.withdraw(-100)).isFalse();
    }

    @Test
    public void cannotOverstep() {
        Account account = new Account(0);
        assertThat(account.withdraw(100)).isFalse();
    }

    @Test
    public void correctAmount() {
        Account account = new Account(0);
        assertThat(account.deposit(100)).isTrue();
        assertThat(account.withdraw(100)).isTrue();
        Assert.assertEquals(0d, account.getBalance(), epsilon);
    }

    @Test
    public void withdrawAndDeposit() {
        Account account = new Account(0);
        assertThat(account.deposit(100)).isTrue();
        assertThat(account.withdraw(100)).isTrue();
    }

}