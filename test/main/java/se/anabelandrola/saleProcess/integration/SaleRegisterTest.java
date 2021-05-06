package main.java.se.anabelandrola.saleProcess.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;

class SaleRegisterTest {

	private SaleRegister saleRegister;
	private SaleDTO sale;
	private List<ItemListDTO> itemList = new ArrayList<>();
	private ItemRegistry itemRegistry;
	private AccountingRegistry accountingRegistry;

	@BeforeEach
	void setUp() throws Exception {
		saleRegister = new SaleRegister();
		itemList.add(new ItemListDTO(63514896, "Yoghurt", 1, 12, 0.72, 12.72));
		sale = new SaleDTO("2021-05-02", "11:48:20", 12, 0.72, 0.0, 12.72, itemList);

	}

	@AfterEach
	void tearDown() throws Exception {
		saleRegister = null;
		itemList = null;
		sale = null;
	}

	@Test
	void testRegisterSale() {
		int expectedResult = 1;
		saleRegister.registerSale(sale);
		int result = saleRegister.getSaleRegister().size();
		assertEquals(expectedResult, result, "Sale is not registred");

	}

	@Test
	void testRegisterSaleIsNull() {
		sale = null;
		int result = 0;
		int registerSale = saleRegister.getSaleRegister().size();
		try {
			saleRegister.registerSale(sale);
		} catch (NullPointerException e) {
			result = saleRegister.getSaleRegister().size();
		}
		int expectedResult = 0;
		assertEquals(expectedResult, result, "Sale is null and is registred in SaleRegister");

	}

	@Test
	void testGetItemRegistry() {
		itemRegistry = new ItemRegistry();
		int expectedResult = 3;
		int result = itemRegistry.getItems().size();
		assertEquals(expectedResult, result, "Item register returns the wrong value");

	}

	@Test
	void testGetItemRegistryIsNull() {
		itemRegistry = null;
		int result = 0;
		try {
			result = itemRegistry.getItems().size();
		} catch (NullPointerException e) {
			int expectedResult = 0;
			assertEquals(expectedResult, result, "Item register returns the wrong value");
		}
	}

	@Test
	void testGetAccountingRegistry() {
		accountingRegistry = new AccountingRegistry();
		accountingRegistry.updateAccounting(sale);
		int expectedResult = 1;
		int result = accountingRegistry.getAccountingRegistry().size();
		assertEquals(expectedResult, result, "Accounting register return the wrong value");
	}

	@Test
	void testGetAccountingRegisterIsNull() {
		accountingRegistry = null;
		int result = 0;
		try {
			result = accountingRegistry.getAccountingRegistry().size();
		} catch (NullPointerException e) {
			int expectedResult = 0;
			assertEquals(expectedResult, result, "Accounting is not registered");
		}

	}

}
