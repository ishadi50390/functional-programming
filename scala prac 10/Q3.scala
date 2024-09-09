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
}

object AccountApp {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(500.0)
    val account2 = new Account(200.0)

    account1.deposit(100.0)
    account1.withdraw(50.0)
    account1.transfer(200.0, account2)

    println(s"Account 1 Balance: $$${account1.getBalance}")
    println(s"Account 2 Balance: $$${account2.getBalance}")
  }
}
