package com.pgr301.exam;

import com.pgr301.exam.model.Account;
import com.pgr301.exam.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public interface BankingCoreSystmeService {

    void transfer(Transaction tx, String fromAccount, String toAccount);

    Account updateAccount(Account a);

    BigDecimal balance(@PathVariable String accountId);

    Account getAccount(String accountNumber);
}
