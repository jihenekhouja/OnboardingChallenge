package com.Transactions.CreditCardTransactions.Modele;

import java.math.BigDecimal;
import java.util.Date;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionModel {
	
	private Integer id;
    private BigDecimal amount;
	private String merchant;
    private String status;
    private Date date;
    
  
}
