class Account(private var balance: Double) {

  // Method to deposit money into the account
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $$${amount}. Current balance: $$${balance}")
  }

  // Method to withdraw money from the account
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdraw amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. Current balance: $$${balance}")
    } else {
      println("Insufficient funds")
    }
  }

  // Method to transfer money to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to another account.")
    } else {
      println("Insufficient funds for transfer")
    }
  }

  // Method to check the current balance
  def getBalance: Double = balance

  // Apply interest based on balance: 5% if positive, 10% if negative
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.10
    }
  }

  override def toString: String = f"Account Balance: $$${balance}%.2f"
}

// Bank Class
class Bank(val accounts: List[Account]) {

  // 4.1: List of accounts with negative balances
  def negativeBalances: List[Account] = {
    accounts.filter(_.getBalance < 0)
  }

  // 4.2: Calculate the sum of all account balances
  def totalBalance: Double = {
    accounts.map(_.getBalance).sum
  }

  // 4.3: Apply interest to all accounts and return the updated balances
  def applyInterestToAll(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  // Method to display all account balances
  def displayAllBalances(): Unit = {
    accounts.foreach(acc => println(acc))
  }
}

object BankApp {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(500.0)
    val account2 = new Account(-200.0)
    val account3 = new Account(1000.0)
    val account4 = new Account(-50.0)

    // Creating a bank with a list of accounts
    val bank = new Bank(List(account1, account2, account3, account4))

    // 4.1: List accounts with negative balances
    println("Accounts with Negative Balances:")
    bank.negativeBalances.foreach(println)

    // 4.2: Total sum of all account balances
    println(s"\nTotal Balance of all accounts: $$${bank.totalBalance}")

    // 4.3: Apply interest to all accounts
    println("\nApplying Interest to All Accounts:")
    bank.applyInterestToAll()
    bank.displayAllBalances()
  }
}
