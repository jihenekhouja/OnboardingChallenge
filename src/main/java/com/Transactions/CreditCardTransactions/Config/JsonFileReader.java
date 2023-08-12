package com.Transactions.CreditCardTransactions.Config;

import java.io.*;
import java.util.List;

import com.Transactions.CreditCardTransactions.Modele.TransactionModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {
	
	private static final String JSON_FILE_PATH = "D:/transactionsMock.json";

    public List<TransactionModel> readJsonFile() throws IOException
    
    {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(JSON_FILE_PATH);
        return objectMapper.readValue(jsonFile, new TypeReference<List<TransactionModel>>() {});     
    }

}
