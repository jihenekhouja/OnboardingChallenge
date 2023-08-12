package com.Transactions.CreditCardTransactions.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Transactions.CreditCardTransactions.Modele.TransactionFilterModel;
import com.Transactions.CreditCardTransactions.Modele.TransactionModel;
import com.Transactions.CreditCardTransactions.Repository.TransactionRepository;
import com.Transactions.CreditCardTransactions.Service.TransactionService;

@RestControllerAdvice
@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
    private TransactionRepository transactionrepository;
	@Autowired
    private TransactionService transactionservice;

	
	@GetMapping("/getAll")
	public List<TransactionModel> GetAllTransaction() {
	    return transactionrepository.GetAllTransaction();
	}
	
	
	@PostMapping("/getAllfiltre")
	public List<TransactionModel> GetAllFiltrageTransaction(
			@RequestBody TransactionFilterModel  transactionfiltermodel
			) {
		
		  List<TransactionModel> TransactionFiltre = transactionrepository.GetAllTransactionFilter(transactionfiltermodel);
	        return TransactionFiltre;
	}
	
	
	 @GetMapping("/GetAllTri")
	 public List<TransactionModel> GetTransactionSortedBySalary() {
	        List<TransactionModel> Transaction = transactionservice.GettransactionSortedByAmount();
	        return Transaction;
	    }
	 
	 
	   @GetMapping("/TransactionsPagination")
	    public List<TransactionModel> getTransactionsByPageAndSize(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        List<TransactionModel> transactionsByPageAndSize = transactionservice.GetTransactionsByPageAndSize(page, size);

	        return transactionsByPageAndSize;
   
	 
	    }
		 
	   @GetMapping("/TransactionsSortedMultiple")
	    public List<TransactionModel> getTransactionsSortedMultiple(
	    		@RequestParam (required = false, name = "amount" ) Boolean amount,
				@RequestParam (required = false, name = "merchant") Boolean merchant,
				@RequestParam (required = false, name = "status") Boolean status) {

	        List<TransactionModel> transactionsByPageAndSize = transactionservice.GetTransactionSortedByFiltre(amount, merchant, status);

	        return transactionsByPageAndSize;
   
	 
	    }   
	   
	  
	   
	
}
