package main.java.se.anabelandrola.saleProcess.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.integration.Printer;
import main.java.se.anabelandrola.saleProcess.integration.RegisterCreator;
import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;

class ControllerTest {
	private Controller control;
	private RegisterCreator registerCreator;
	private Printer printer;
	int idItem = 63514896;
	SaleDTO sale;
	ItemListDTO item;

	@BeforeEach
	void setUp() throws Exception {
		registerCreator = new RegisterCreator();
		printer = new Printer();
		control = new Controller(registerCreator, printer);
	}

	@AfterEach
	void tearDown() throws Exception {
		registerCreator = null;
		printer = null;
		control = null;
	}

	@Test
	void testStartSaleSuccessfully() {
		control.startSale();
		boolean result = false;
		item = control.registerItem(idItem);
		if (item != null)
			result = true;
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Item is not regristed");
	}

	@Test
	void testRegisterItemSuccessfully() {
		control.startSale();
		boolean result = false;
		item = control.registerItem(idItem);
		if (item != null)
			result = true;
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Item is not regristed");
	}

	@Test
	void testRegisterItemSaleIsNotCreate() {
		int result = 0;
		int expectedResult = 0;
		try {
			item = control.registerItem(idItem);
			sale = control.generateSale();
			result = sale.getItems().size();
		} catch (NullPointerException e) {
			assertEquals(expectedResult, result, "Sale is created");
		}
	}

	@Test
	void testRegisterItemNotExist() {
		idItem = 63514234;
		control.startSale();
		boolean result = false;
		try {
			item = control.registerItem(idItem);
		} catch (NullPointerException e) {
			if (item != null)
				result = true;
			boolean expectedResult = false;
			assertEquals(expectedResult, result, "Sale is created");
		}
	}

	@Test
	void testRegisterItemIsZero() {
		idItem = 0;
		control.startSale();
		boolean result = false;
		try {
			item = control.registerItem(idItem);
		} catch (NullPointerException e) {
			if (item != null)
				result = true;
			boolean expectedResult = false;
			assertEquals(expectedResult, result, "Sale is created");
		}
	}

	@Test
	void testGenerateSaleSuccessful() {
		control.startSale();
		item = control.registerItem(idItem);
		sale = control.generateSale();
		boolean result = false;
		if (sale != null)
			result = true;
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Sale is not saved");
	}

	@Test
	void testGenerateSaleIsSaleNull() {
		boolean result = false;
		try {
			sale = control.generateSale();

		} catch (NullPointerException e) {
			if (sale != null)
				result = true;
			boolean expectedResult = false;
			assertEquals(expectedResult, result, "Sale is null och is generated");
		}
	}

	@Test
	void testPaySuccesfullCashRegisterIncreases() {
		double paidAmount = 40;
		control.startSale();
		item = control.registerItem(idItem);
		sale = control.generateSale();
		control.pay(paidAmount);
		double expectedResult = 12.72;
		double result = control.getAmountCashRegister();
		assertEquals(expectedResult, result, "Cash Register is not increased");
	}

	@Test
	void testPaySuccesfullSaleRegisterUpdates() {
		double paidAmount = 40;
		control.startSale();
		item = control.registerItem(idItem);
		control.generateSale();
		control.pay(paidAmount);
		int expectedResult = 1;
		int result = registerCreator.getSaleRegister().getSaleRegister().size();
		assertEquals(expectedResult, result, "SaleRegister is not updated");
	}

	@Test
	void testPayPaidAmountIsZero() {
		double paidAmount = 0;
		control.startSale();
		item = control.registerItem(idItem);
		sale = control.generateSale();
		try {
			control.pay(paidAmount);
		} catch (IllegalArgumentException e) {
			double expectedResult = 0;
			double result = control.getAmountCashRegister();
			assertEquals(expectedResult, result,
					"The amount paid is less than the total cost of the sale. Sale is paid");
		}
	}

}
