//author: Krishna Mohan Tiwari
// Date: March 21, 2023
// Test cases for this program are in test folder

import scala.util.Random

// Define a case class for transactions
case class Transactions(transactionId: Long, accountNumber: Long, transactionType: String, amount: Double)

// Define the Bank class
class Bank(private val accounts: Map[Long, Double]) {

  // Create new account by allocating random account number and depositing balance in account
  def createAccount(openingBalance: Double): (Bank, Long) = {
    val accountNumber = generateAccountNumber() // Generate a random account number
    val newAccounts = accounts + (accountNumber -> openingBalance) // Add the new account to the accounts map
    (new Bank(newAccounts), accountNumber) // Return the new Bank instance and the account number
  }

  // List all accounts with balance
  def listAccounts(): Map[Long, Double] = accounts

  // Fetch account balance using account number
  def fetchAccountBalance(accountNumber: Long): Option[Double] = {
    accounts.get(accountNumber).orElse(None) // Return the balance of the account with the given account number, or None if the account does not exist
  }

  // Update account balance based on list of transactions
  def updateBalance(transactions: List[Transactions]): (Bank, Map[Long, Double]) = {
    // Fold over the transactions and update the account balances in the accounts map
    val updatedAccounts = transactions.foldLeft(accounts) { (currentAccounts, transaction) =>
      val accountBalance = currentAccounts.getOrElse(transaction.accountNumber, 0.0) // Get the current balance of the account
      val updatedBalance = transaction.transactionType match {
        case "credit" => accountBalance + transaction.amount // Add the transaction amount to the balance for credit transactions
        case "debit" => accountBalance - transaction.amount // Subtract the transaction amount from the balance for debit transactions
        case _ => accountBalance // For any other transaction types, do not update the balance
      }
      currentAccounts + (transaction.accountNumber -> updatedBalance) // Update the accounts map with the new balance for the account
    }
    (new Bank(updatedAccounts), updatedAccounts) // Return the new Bank instance and the updated accounts map
  }

  // Delete account using account number
  def deleteAccount(accountNumber: Long): Option[Bank] = {
    if (accounts.contains(accountNumber)) { // If the account with the given account number exists,
      val newAccounts = accounts - accountNumber // remove it from the accounts map
      Some(new Bank(newAccounts)) // Return a new Bank instance with the updated accounts map
    } else {
      None // If the account with the given account number does not exist, return None
    }
  }

  // Generate a random account number
  private def generateAccountNumber(): Long = Random.nextLong()

  //Transfer function that allows transferring money from one account to another(additional functionality - NOT mentioned in the assignment)
  def transferMoney(fromAccountNumber: Long, toAccountNumber: Long, amount: Double): Option[Bank] = {
    if (accounts.contains(fromAccountNumber) && accounts.contains(toAccountNumber)) { // Check if both accounts exist
      val fromAccountBalance = accounts(fromAccountNumber)
      if (fromAccountBalance >= amount) { // Check if the from account has enough balance for the transfer
        val toAccountBalance = accounts(toAccountNumber)
        val updatedAccounts = accounts + (fromAccountNumber -> (fromAccountBalance - amount)) + (toAccountNumber -> (toAccountBalance + amount))
        Some(new Bank(updatedAccounts)) // Return a new Bank instance with the updated accounts map
      } else {
        None // If the from account does not have enough balance, return None
      }
    } else {
      None // If either or both of the accounts do not exist, return None
    }
  }

}

object Bank {
  // Create a new bank with no accounts
  def apply(): Bank = new Bank(Map.empty)
}

//for any doubts mail me at krishna.tiwari@knoldus.com