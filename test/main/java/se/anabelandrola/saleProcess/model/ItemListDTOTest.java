package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemListDTOTest {
	ItemListDTO itemList;

	@BeforeEach
	void setUp() throws Exception {
		itemList = new ItemListDTO(63514896, "Yoghurt", 1, 12, 0.72, 12.72);
	}

	@AfterEach
	void tearDown() throws Exception {
		itemList = null;
	}

	@Test
	void testToString() {
		String idItem = Integer.toString(63514896);
		String description = "Yoghurt";
		String quantity = Integer.toString(1);
		String totalAmountWithoutVAT = Double.toString(12.0);
		String totalVAT = Double.toString(0.72);
		String totalAmountWithVAT = Double.toString(12.72);
		String expectedResult = "idItem: " + idItem + ", " + "description: " + description + ", " + "quantity: "
				+ quantity + ", " + "totalAmountWithoutVAT: " + totalAmountWithoutVAT + ", " + "totalVAT: " + totalVAT
				+ ", " + "totalAmountWithVAT: " + totalAmountWithVAT + ", ";
		String result = itemList.toString();
		assertEquals(expectedResult, result, "Wrong string returned by toString");
	}

}
