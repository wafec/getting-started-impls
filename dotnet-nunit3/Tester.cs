using System;
using dotnet_nunit3;
using NUnit.Framework;

[TestFixture]
public class Tester
{
    private double epsilon = 1e-6;

    [Test]
    public void TheDepositAndWithdrawMethodsWillNotAcceptNegativeNumbers()
    {
        Account account = new Account(20);

        account.Deposit(-1);
        Assert.AreEqual(0, account.Balance, epsilon);
        account.Withdraw(-1);
        Assert.AreEqual(0, account.Balance, epsilon);
    }

    [Test]
    public void AccountCannotOverstepItsOverdraftLimit()
    {
        Account account = new Account(20);
        account.Withdraw(21);
        Assert.AreEqual(0, account.Balance, epsilon);
    }

    [Test]
    public void TheDepositAndWithdrawMethodsWillDepositOrWithdrawTheCorrectAmount()
    {
        Account account = new Account(20);
        account.Deposit(20);
        Assert.AreEqual(20, account.Balance, epsilon);
        account.Withdraw(20);
        Assert.AreEqual(0, account.Balance, epsilon);
    }

    [Test]
    public void TheWithdrawAndDepositMethodsReturnTheCorrectResults()
    {
        Account account = new Account(20);
        bool result;
        result = account.Deposit(20);
        Assert.IsTrue(result);
        result = account.Withdraw(20);
        Assert.IsTrue(result);
    }
}