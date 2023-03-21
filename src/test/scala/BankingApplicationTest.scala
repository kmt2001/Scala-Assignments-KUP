import org.scalatest.funsuite.AnyFunSuite

// Defining a test suite for the banking application
class BankingApplicationTest extends AnyFunSuite {

  // Testing the creation of a new account
  test("create account") {
    val bank = Bank()
    val openingBalance = 100.0
    val (newBank, accountNumber) = bank.createAccount(openingBalance)
    assert(newBank.listAccounts().contains(accountNumber))
    assert(newBank.listAccounts()(accountNumber) == openingBalance)
  }

  // Testing the listing of all accounts with their balances
  test("list accounts") {
    val bank = Bank()
    val openingBalance1 = 100.0
    val (newBank1, accountNumber1) = bank.createAccount(openingBalance1)
    val openingBalance2 = 200.0
    val (newBank2, accountNumber2) = newBank1.createAccount(openingBalance2)
    val accounts = newBank2.listAccounts()
    assert(accounts.size == 2)
    assert(accounts.contains(accountNumber1))
    assert(accounts(accountNumber1) == openingBalance1)
    assert(accounts.contains(accountNumber2))
    assert(accounts(accountNumber2) == openingBalance2)
  }

  // Testing the fetching of an account balance using the account number
  test("fetch account balance") {
    val bank = Bank()
    val openingBalance = 100.0
    val (newBank, accountNumber) = bank.createAccount(openingBalance)
    assert(newBank.fetchAccountBalance(accountNumber).contains(openingBalance))
    assert(newBank.fetchAccountBalance(accountNumber + 1).isEmpty)
  }

  // Testing the updating of account balances based on a list of transactions
  test("update balance") {
    val bank = Bank()
    val openingBalance1 = 100.0
    val (newBank1, accountNumber1) = bank.createAccount(openingBalance1)
    val openingBalance2 = 200.0
    val (newBank2, accountNumber2) = newBank1.createAccount(openingBalance2)
    val transactions = List(
      Transactions(1, accountNumber1, "credit", 50.0),
      Transactions(2, accountNumber2, "debit", 100.0),
      Transactions(3, accountNumber1, "debit", 25.0),
    )
    val (updatedBank, updatedAccounts) = newBank2.updateBalance(transactions)
    assert(updatedAccounts.size == 2)
    assert(updatedAccounts(accountNumber1) == 125.0)
    assert(updatedAccounts(accountNumber2) == 100.0)
    assert(updatedBank.fetchAccountBalance(accountNumber1).contains(125.0))
    assert(updatedBank.fetchAccountBalance(accountNumber2).contains(100.0))
  }

  // Testing the deletion of an account using the account number
  test("delete account") {
    val bank = Bank()
    val openingBalance = 100.0
    val (newBank, accountNumber) = bank.createAccount(openingBalance)
    assert(newBank.listAccounts().contains(accountNumber))
    val deletedBank = newBank.deleteAccount(accountNumber)
    assert(deletedBank.isDefined)
    assert(deletedBank.get.listAccounts().isEmpty)
    assert(deletedBank.get.fetchAccountBalance(accountNumber).isEmpty)
  }

  // Test transferring money from one account to another(additional functionality i added)
  test("transfer money") {
    val bank = Bank()
    val (newBank, accountNumber1) = bank.createAccount(1000.0)
    val (newBank2, accountNumber2) = newBank.createAccount(2000.0)
    val updatedBank = newBank2.transferMoney(accountNumber1, accountNumber2, 500.0)
    assert(updatedBank.isDefined)
    assert(updatedBank.get.fetchAccountBalance(accountNumber1) == Some(500.0))
    assert(updatedBank.get.fetchAccountBalance(accountNumber2) == Some(2500.0))
  }
}