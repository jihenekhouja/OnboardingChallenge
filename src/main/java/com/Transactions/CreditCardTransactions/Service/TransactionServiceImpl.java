package com.Transactions.CreditCardTransactions.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Transactions.CreditCardTransactions.Modele.TransactionFilterModel;
import com.Transactions.CreditCardTransactions.Modele.TransactionModel;
import com.Transactions.CreditCardTransactions.Repository.TransactionRepository;


@Service(" TransactionService")
public class TransactionServiceImpl implements  TransactionService {

	@Autowired 
	TransactionRepository transactionrepository;
	
	@Override
	public List<TransactionModel> GetTransactionSortedByFiltre(Boolean amount, Boolean merchant, Boolean status)
	{
		List<TransactionModel> AllTransaction = transactionrepository.GetAllTransaction();
		List<TransactionModel> AllTransactionsorted = transactionrepository.GetAllTransaction();
		
		
		if(Boolean.TRUE.equals(amount) && amount !=null) {  
			AllTransactionsorted= AllTransaction.stream()
	            .sorted(Comparator.comparing(TransactionModel::getAmount) )
	            .collect(Collectors.toList()); 
			}
		
		else  if (Boolean.TRUE.equals(merchant) && merchant !=null) {
    	 AllTransactionsorted= AllTransaction.stream()
 	            .sorted(Comparator.comparing(TransactionModel::getMerchant) )
 	            .collect(Collectors.toList());
     }
		else if (Boolean.TRUE.equals(status) && status !=null) {
    		 AllTransactionsorted= AllTransaction.stream()
    	 	            .sorted(Comparator.comparing(TransactionModel::getStatus) )
    	 	            .collect(Collectors.toList());
     }
		
		return AllTransactionsorted;
		
	}

	@Override
	public List<TransactionModel> GetTransactionsByPageAndSize(int page, int size) {
		List<TransactionModel> AllTransaction = transactionrepository.GetAllTransaction();
	     int startIndex = page * size;
	     int endIndex = Math.min(startIndex + size, AllTransaction.size());
	     return AllTransaction.subList(startIndex, endIndex);
	}

	@Override
	public List<TransactionModel> GettransactionSortedByAmount()  {
		List<TransactionModel> AllTransaction = transactionrepository.GetAllTransaction();
        return AllTransaction.stream()
            .sorted(Comparator.comparing(TransactionModel::getAmount))
            .collect(Collectors.toList())
	}

}
