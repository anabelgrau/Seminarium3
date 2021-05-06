package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaleDTOTest {
	private List<ItemListDTO> itemList = new ArrayList<>();
	private SaleDTO sale;

	@BeforeEach
	void setUp() throws Exception {
		itemList.add(new ItemListDTO(63514896, "Yoghurt", 1, 12, 0.72, 12.72));
		sale = new SaleDTO("2021-05-02", "11:48:20", 12, 0.72, 0.0, 12.72, itemList);
	}

	@AfterEach
	void tearDown() throws Exception {
		itemList = null;
		sale = null;
	}

	@Test
	void testToString() {
		String date = "2021-05-02";
		String time = "11:48:20";
		String amountSale = Double.toString(12);
		String amountVAT = Double.toString(0.72);
		String amountDiscount = Double.toString(0);
		String amountTotalWithVAT = Double.toString(12.72);
		String expectedResult = "date: " + date + ", " + "time: " + time + ", " + "amountSale " + amountSale + ", "
				+ "amountVAT: " + amountVAT + ", " + "amountDiscount: " + amountDiscount + ", " + "amountTotalWithVAT "
				+ amountTotalWithVAT + ", " + "items " + itemList.toString() + ", ";
		String result = sale.toString();
		assertEquals(expectedResult, result, "Wrong string returned by toString");
	}

}
