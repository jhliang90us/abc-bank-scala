package com.abc

import org.scalatest.{Matchers, FlatSpec}

import com.abc.AccountType._


class CustomerTest extends FlatSpec with Matchers {

  "Customer" should "testOneAccount" in {
    val oscar: Customer = new Customer("Oscar").openAccount(new MyAccount(SAVINGS))
    oscar.numberOfAccounts should be(1)
  }
  
  ignore  should "statement" in {
    val checkingAccount: MyAccount = new MyAccount(CHECKING)
    val savingsAccount: MyAccount = new MyAccount(SAVINGS)
    val henry: Customer = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount)
    checkingAccount.deposit(100.0)
    savingsAccount.deposit(4000.0)
    savingsAccount.withdraw(200.0)
    henry.getStatement should be("Statement for Henry\n" +
      "\nChecking Account\n  deposit $100.00\nTotal $100.00\n" +
      "\nSavings Account\n  deposit $4000.00\n  withdrawal $200.00\nTotal $3800.00\n" +
      "\nTotal In All Accounts $3900.00")
  }  

  it should "testTwoAccount" in {
    val oscar: Customer = new Customer("Oscar").openAccount(new MyAccount(SAVINGS))
    oscar.openAccount(new MyAccount(CHECKING))
    oscar.numberOfAccounts should be(2)
  }

  ignore should "testThreeAcounts" in {
    val oscar: Customer = new Customer("Oscar").openAccount(new MyAccount(SAVINGS))
    oscar.openAccount(new MyAccount(CHECKING))
    oscar.numberOfAccounts should be(3)
  }
}
