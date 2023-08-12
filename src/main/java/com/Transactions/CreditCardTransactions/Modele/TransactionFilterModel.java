package com.Transactions.CreditCardTransactions.Modele;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilterModel {

	private BigDecimal amount;
	private String merchant;
	private String status;
	
}
