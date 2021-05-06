package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.integration.ItemDTO;

class ItemListTest {
	private ItemList itemList;
	private ItemDTO item;
	private ItemDTO itemYoghurt;

	@BeforeEach
	void setUp() throws Exception {
		itemList = new ItemList();
		itemYoghurt = new ItemDTO(63514896, "Yoghurt", 12, 6, 3);
		item = new ItemDTO(43560294, "Milk", 10, 6, 2);

	}

	@AfterEach
	void tearDown() throws Exception {
		itemList = null;
		item = null;
	}

	@Test
	void testSaveItemSuccessfully() {
		itemList.saveItem(item);
		int result = itemList.getItemList().size();
		int expectedResult = 1;
		assertEquals(expectedResult, result, "Item is not added");
	}

	@Test
	void testSaveItemItemIsNull() {
		item = null;
		try {
			itemList.saveItem(item);
		} catch (NullPointerException e) {
			int result = itemList.getItemList().size();
			int expectedResult = 0;
			assertEquals(expectedResult, result, "Item is null and is added");
		}
	}

	@Test
	void testSearchItemListFoundItem() {
		itemList.saveItem(item);
		boolean result = itemList.searchItemList(item);
		boolean expectedResult = true;
		assertEquals(expectedResult, result, "Item is not found");
	}

	@Test
	void testSearchItemListIsNotFoundItem() {
		itemList.saveItem(item);
		boolean result = itemList.searchItemList(itemYoghurt);
		boolean expectedResult = false;
		assertEquals(expectedResult, result, "Items with different idItem are found");
	}

	@Test
	void testSearchItemListFoundNullItem() {
		itemList.saveItem(item);
		boolean result = false;
		ItemDTO item = null;
		try {
			result = itemList.searchItemList(item);
		} catch (NullPointerException e) {
			boolean expectedResult = false;
			assertEquals(expectedResult, result, "Item null is found");
		}
	}

	@Test
	void testIncreaseQuantitySucessfully() {
		itemList.saveItem(item);
		itemList.increaseQuantity(item);
		int expectedResult = 2;
		int result = itemList.getItemList().get(0).getQuantity();
		assertEquals(expectedResult, result, "Item is not found");

	}

	@Test
	void testIncreaseQuantityWhenItemIsNotItemList() {
		itemList.saveItem(item);
		itemList.increaseQuantity(itemYoghurt);
		int expectedResult = 1;
		int result = itemList.getItemList().get(0).getQuantity();
		assertEquals(expectedResult, result, "Item is not found");
	}

	@Test
	void testIncreaseQuantityWhenItemtItemIsNull() {
		itemList.saveItem(item);
		item = null;
		try {
			itemList.increaseQuantity(item);
		} catch (NullPointerException e) {
			int expectedResult = 1;
			int result = itemList.getItemList().get(0).getQuantity();
			assertEquals(expectedResult, result, "Item is not found");
		}
	}
}
