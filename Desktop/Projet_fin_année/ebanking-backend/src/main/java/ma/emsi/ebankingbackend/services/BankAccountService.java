package ma.emsi.ebankingbackend.services;

import ma.emsi.ebankingbackend.dtos.*;
import ma.emsi.ebankingbackend.entities.BankAccount;
import ma.emsi.ebankingbackend.entities.CurrentAccount;
import ma.emsi.ebankingbackend.entities.Customer;
import ma.emsi.ebankingbackend.entities.SavingAccount;
import ma.emsi.ebankingbackend.exeptions.BalanceNotSufficientException;
import ma.emsi.ebankingbackend.exeptions.BankAccountNotFoundExeption;
import ma.emsi.ebankingbackend.exeptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
     CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
     List<CustomerDTO> listCustomers();
     BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundExeption;
     void debit(String accountId, double amount, String description) throws BankAccountNotFoundExeption, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundExeption;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundExeption, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundExeption;

    List<CustomerDTO> searchCustomers(String keyword);
}
