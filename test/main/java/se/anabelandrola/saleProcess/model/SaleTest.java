package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.integration.ItemDTO;

class SaleTest {

	private Sale sale;
	private ItemDTO item;
	private Payment pay;
	ItemListDTO itemListDTO;
	SaleDTO saleDTO;

	@BeforeEach
	void setUp() throws Exception {
		item = new ItemDTO(63514896, "Yoghurt", 12, 6, 3);
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		item = null;
		sale = null;
	}

	@Test
	void testRegisterItemSuccessfullyFirstTime() {
		itemListDTO = sale.registerItem(item);
		boolean result = false;
		if (itemListDTO != null)
			result = true;
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Item is not registered");
	}

	@Test
	void testRegisterItemSuccesfullySecondTime() {
		itemListDTO = sale.registerItem(item);
		boolean result = false;
		if (itemListDTO != null)
			result = true;
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Item is not increased");
	}

	@Test
	void testRegisterItemIsItemNull() {
		item = null;
		boolean result = false;
		try {
			itemListDTO = sale.registerItem(item);
		} catch (NullPointerException e) {
			if (itemListDTO != null)
				result = false;
			boolean expectedResult = false;
			assertEquals(expectedResult, result, "Item that is null is registered");
		}
	}

	@Test
	void testSaveSaleSuccessfully() {
		saleDTO = sale.saveSale();
		boolean result = false;
		if (saleDTO != null)
			result = true;
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Sale is not saved");
	}

	@Test
	void testSaveSaleIsSaleNull() {
		boolean result = false;
		sale = null;
		try {
			saleDTO = sale.saveSale();
		} catch (NullPointerException e) {
			if (saleDTO != null)
				result = true;
			boolean expectedResult = false;
			assertEquals(expectedResult, result, "Sale is null och saved");
		}
	}

	@Test
	void testPaySuccessfully() {
		double paidAmount = 40;
		pay = new Payment(paidAmount);
		itemListDTO = sale.registerItem(item);
		saleDTO = sale.saveSale();
		sale.pay(pay);
		double expectedResult = saleDTO.getAmountTotalWithVAT();
		double result = pay.getTotalCost();
		assertEquals(expectedResult, result, "Total amount is incorrect");
	}

	@Test
	void testPayPaidAmountlessSale() {
		double paidAmount = 4;
		pay = new Payment(paidAmount);
		itemListDTO = sale.registerItem(item);
		saleDTO = sale.saveSale();
		boolean result = false;
		try {
			sale.pay(pay);
		} catch (IllegalArgumentException e) {
			result = true;
		}
		assertTrue(result, "Wrong printout.");
	}

}
