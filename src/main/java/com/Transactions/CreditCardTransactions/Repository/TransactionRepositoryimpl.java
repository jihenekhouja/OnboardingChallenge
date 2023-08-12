package com.Transactions.CreditCardTransactions.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import com.Transactions.CreditCardTransactions.Config.JsonFileReader;
import com.Transactions.CreditCardTransactions.Exception.InvalidInputException;
import com.Transactions.CreditCardTransactions.Modele.TransactionFilterModel;
import com.Transactions.CreditCardTransactions.Modele.TransactionModel;
@Service("TransactionRepository")
public class  TransactionRepositoryimpl implements TransactionRepository  {

	@Override
	public List<TransactionModel> GetAllTransaction() {
		 try {
			 JsonFileReader jsonFileReader = new JsonFileReader();
	            return jsonFileReader.readJsonFile();   
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public List<TransactionModel> GetAllTransactionFilter(TransactionFilterModel transactionfiltermodel) {
		List<TransactionModel> AllTransaction = GetAllTransaction();
		
		if (transactionfiltermodel.getAmount().compareTo(BigDecimal.ZERO) < 0 ) {
		    throw new InvalidInputException("Amount n'est pas  negative.");
		}

		else if (!transactionfiltermodel.getStatus().equals("approved") && !transactionfiltermodel.getStatus().equals("refused")   ) {
		    throw new InvalidInputException("status prend deux valeur soit approved ou refused ");
		}
		else	if(transactionfiltermodel.getAmount()!= null  ) 
				{
					AllTransaction= AllTransaction.stream()
			                    .filter(transaction -> transaction.getAmount().compareTo(transactionfiltermodel.getAmount()) == 0 ||
			                    transaction.getMerchant().equalsIgnoreCase(transactionfiltermodel.getMerchant()) || transaction.getStatus().equalsIgnoreCase(transactionfiltermodel.getStatus()))
			                    .collect(Collectors.toList());
					
					  
				}
		else if(transactionfiltermodel.getMerchant()!= null && !transactionfiltermodel.getMerchant().equals("")) 
				{
			AllTransaction= AllTransaction.stream()
                    .filter(transaction -> transaction.getAmount().compareTo(transactionfiltermodel.getAmount()) == 0 ||
                    transaction.getMerchant().equalsIgnoreCase(transactionfiltermodel.getMerchant()) || transaction.getStatus().equalsIgnoreCase(transactionfiltermodel.getStatus()))
                    .collect(Collectors.toList());
				}
		else	if(transactionfiltermodel.getStatus()!= null && !transactionfiltermodel.getStatus().equals("")) 
				{	
			AllTransaction= AllTransaction.stream()
                    .filter(transaction -> transaction.getAmount().compareTo(transactionfiltermodel.getAmount()) == 0 ||
                    transaction.getMerchant().equalsIgnoreCase(transactionfiltermodel.getMerchant()) || transaction.getStatus().equalsIgnoreCase(transactionfiltermodel.getStatus()))
                    .collect(Collectors.toList());
				}
				
				
				
					return AllTransaction;
							
			}
			
	}

}
