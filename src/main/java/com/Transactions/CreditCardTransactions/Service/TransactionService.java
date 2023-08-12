package com.Transactions.CreditCardTransactions.Service;

import java.util.List;

import com.Transactions.CreditCardTransactions.Modele.TransactionFilterModel;
import com.Transactions.CreditCardTransactions.Modele.TransactionModel;

public interface TransactionService {
	public List<TransactionModel> GettransactionSortedByAmount();
	public List<TransactionModel> GetTransactionsByPageAndSize(int page, int size);
	public List<TransactionModel> GetTransactionSortedByFiltre(Boolean amount, Boolean merchant, Boolean status );
}
