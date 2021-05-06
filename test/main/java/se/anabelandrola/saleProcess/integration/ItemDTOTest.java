package main.java.se.anabelandrola.saleProcess.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemDTOTest {
	
	private ItemDTO itemMilk;

	@BeforeEach
	void setUp() throws Exception {
		itemMilk= new ItemDTO(43560294, "Milk", 10, 6, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		itemMilk = null;
	}

	@Test
	void testEqual() {
		ItemDTO itemOther = new ItemDTO(43560294, "Milk", 10, 6, 2);
		boolean expectedResult = true;
		boolean result = itemMilk.equals(itemOther);
		assertEquals(expectedResult,result,"Items are not equal");
	}
	@Test
	void testNotEqual() {
		ItemDTO itemOther = new ItemDTO(43560897, "Coca cola", 2, 6, 7);
		boolean expectedResult = false;
		boolean result = itemMilk.equals(itemOther);
		assertEquals(expectedResult,result,"Items with different values are equal");
	}
	@Test
	void testEqualIsNullItem() {
		ItemDTO itemOther = null;
		boolean expectedResult = false;
		boolean result = itemMilk.equals(itemOther);
		assertEquals(expectedResult,result,"Items equals to null");
	}
	@Test
	void testEqualJavaLangObject() {
		Object itemOther = new Object();
		boolean expectedResult = false;
		boolean result = itemMilk.equals(itemOther);
		assertEquals(expectedResult,result,"Item is equal in the java.lang.Object instance");
	}

	@Test
	void testToString() {
		String idItem = Integer.toString(43560294);
		String description = "Milk";
		String price = Double.toString(10.0);
		String vat = Integer.toString(6);
		String quantity = Integer.toString(2);
		String expectedResult = "idItem: " + idItem + ", " + "description: " + description + ", " + "price: " + price
				+ ", " + "VAT: " + vat + ", " + "quantitySold: " + quantity + ", ";
		String result = itemMilk.toString();
		assertEquals(expectedResult, result, "Wrong string returned by toString");
	}

}
