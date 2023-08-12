package com.Transactions.CreditCardTransactions.Repository;

import java.util.List;

import com.Transactions.CreditCardTransactions.Modele.TransactionFilterModel;
import com.Transactions.CreditCardTransactions.Modele.TransactionModel;

public interface TransactionRepository {
	public List<TransactionModel> GetAllTransaction();
	public List<TransactionModel> GetAllTransactionFilter(TransactionFilterModel transactionfiltermodel );
}
