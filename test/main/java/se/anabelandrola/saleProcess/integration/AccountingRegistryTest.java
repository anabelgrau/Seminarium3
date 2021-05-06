package main.java.se.anabelandrola.saleProcess.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;

class AccountingRegistryTest {
	
	private List<ItemListDTO> itemList = new ArrayList<>();
	private SaleDTO sale;
	private AccountingRegistry accountingRegistry;

	@BeforeEach
	void setUp() throws Exception {
		accountingRegistry = new AccountingRegistry();
		itemList.add (new ItemListDTO (63514896, "Yoghurt",1, 12, 0.72,12.72));    
		sale = new SaleDTO("2021-05-02","11:48:20",12,0.72,0.0,12.72,itemList);
		
	}
	@AfterEach
	void tearDown() throws Exception {
		itemList= null;
		sale = null;
		accountingRegistry = null;
	}
	@Test
	void testUpdateAccountingSuccessfully() {
		accountingRegistry.updateAccounting(sale);
		int result = accountingRegistry.getAccountingRegistry().size();
		int expectedResult = 1;
		assertEquals(expectedResult,result,"Accounting is not updated");
	}
	@Test
	void testUpdateAccountingNullValues() {
		sale = null;
		int result = accountingRegistry.getAccountingRegistry().size();
		try {
		accountingRegistry.updateAccounting(sale);
		}catch(NullPointerException e)
		{
			result = accountingRegistry.getAccountingRegistry().size();
		}
		int expectedResult= 0;
		assertEquals(expectedResult,result,"Accountings with null values are added.");	
	}
}
