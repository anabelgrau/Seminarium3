package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashRegisterTest {

	private CashRegister cashRegister;
	private Payment pay;
	private double paidAmount = 25;
	private List<ItemListDTO> itemList = new ArrayList<>();
	private SaleDTO sale;

	@BeforeEach
	void setUp() throws Exception {
		cashRegister = new CashRegister();
		pay = new Payment(paidAmount);
		itemList.add(new ItemListDTO(63514896, "Yoghurt", 1, 12, 0.72, 12.72));
		sale = new SaleDTO("2021-05-02", "11:48:20", 12, 0.72, 0.0, 12.72, itemList);

	}

	@AfterEach
	void tearDown() throws Exception {
		cashRegister = null;
		pay = null;
		itemList = null;
		sale = null;
	}

	@Test
	void testIncreasesAmountSuccessfully() {
		pay.calculateTotalAmount(sale);
		double expectedResult = 12.72;
		cashRegister.increasesAmount(pay);
		double result = cashRegister.getAmount();
		assertEquals(expectedResult, result, "Amount is not increased");
	}

	@Test
	void testIncreasesAmountTwiceSuccessfully() {
		pay.calculateTotalAmount(sale);
		double expectedResult = 25.44;
		cashRegister.increasesAmount(pay);
		double result = cashRegister.getAmount();
		cashRegister.increasesAmount(pay);
		result = cashRegister.getAmount();
		assertEquals(expectedResult, result, "Amount is not increased");
	}

	@Test
	void testIncreasesAmountNullSale() {
		sale = null;
		try {
			pay.calculateTotalAmount(sale);
		} catch (NullPointerException e) {
			double expectedResult = 0;
			cashRegister.increasesAmount(pay);
			double result = cashRegister.getAmount();
			cashRegister.increasesAmount(pay);
			result = cashRegister.getAmount();
			assertEquals(expectedResult, result, "Amount increases when sale is null");
		}
	}

}
