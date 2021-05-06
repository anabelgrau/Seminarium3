package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.integration.ItemDTO;
import main.java.se.anabelandrola.saleProcess.integration.Printer;

class ReceiptTest {
	private Receipt receipt;
	private Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		sale = new Sale();

	}

	@AfterEach
	void tearDown() throws Exception {
		sale = null;
	}

	@Test
	void testCreateReceiptSuccessfully() {
		ItemDTO item = new ItemDTO(63514896, "Yoghurt", 12, 6, 3);
		sale.registerItem(item);
		sale.saveSale();
		double paidAmount = 40;
		Payment pay = new Payment(paidAmount);
		sale.pay(pay);
		Printer printer = new Printer();
		sale.printReceipt(printer);
		receipt = new Receipt(sale);
		String result = receipt.createReceipt();
		String date = LocalDate.now().toString();
		String description = "Yoghurt";
		String price = String.valueOf(12.72);
		String expectedResult = "Item's name:" + description;
		assertTrue(result.contains(expectedResult), "Wrong printout.");
		assertTrue(result.contains(price), "Wrong printout.");
		assertTrue(result.contains(date), "Wrong printout.");
	}

}
