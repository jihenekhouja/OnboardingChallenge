package com.Transactions.CreditCardTransactions.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Transactions.CreditCardTransactions.Controller.TransactionController;
import com.Transactions.CreditCardTransactions.Modele.TransactionFilterModel;
import com.Transactions.CreditCardTransactions.Modele.TransactionModel;
import com.Transactions.CreditCardTransactions.Repository.TransactionRepository;
import com.Transactions.CreditCardTransactions.Service.TransactionService;

@WebMvcTest(TransactionController.class)
public class TransactionTest {
	@Autowired
    private MockMvc mockMvc;
	 
	 @MockBean
	    private TransactionController transactionController;
	 
	 
	 @Mock
	    private TransactionRepository transactionRepository;
	 
	 @Mock
	    private TransactionService transactionService;
	@Test
	    public void testGetAllTransaction() throws Exception {   
	        mockMvc.perform(post("/api/getAll"))
           .andExpect(status().isOk());  
	    } 
	
	
	
    @Test
    public void testGetAllFiltrageTransaction() throws Exception {
        List<TransactionModel> transactions = new ArrayList<>();
        Mockito.when(transactionRepository.GetAllTransactionFilter(null)).thenReturn(transactions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/getAllfiltre"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
      
    }
    @Test
    public void testGetAllFiltrageTransactionWithAmount() throws Exception {
      
        BigDecimal amount = new BigDecimal("100.00");
        List<TransactionModel> transactions = new ArrayList<>();
        Mockito.when(transactionRepository.GetAllTransactionFilter( null)).thenReturn(transactions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/getAllfiltre")
                .param("amount", "100.00"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }
    
    
    @Test
    public void testGetTransactionSortedBySalary() throws Exception {
     
        List<TransactionModel> transactions = new ArrayList<>();
        Mockito.when(transactionService.GettransactionSortedByAmount()).thenReturn(transactions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/GetAllTri"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
       
    }
    
    @Test
    public void testGetTransactionsByPageAndSize() throws Exception {
     
        List<TransactionModel> transactions = new ArrayList<>();
        Mockito.when(transactionService.GetTransactionsByPageAndSize(Mockito.anyInt(), Mockito.anyInt())).thenReturn(transactions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/TransactionsPagination")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
       
    }
    @Test
    public void testGetTransactionsSortedMultiple() throws Exception {
     
        List<TransactionModel> transactions = new ArrayList<>();
        Mockito.when(transactionService.GetTransactionSortedByFiltre(Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyBoolean())).thenReturn(transactions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/TransactionsSortedMultiple")
                .param("amount", "true")
                .param("merchant", "false")
                .param("status", "true"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
     
    }
	
	
	
}
