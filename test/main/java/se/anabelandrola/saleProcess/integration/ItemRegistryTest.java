package main.java.se.anabelandrola.saleProcess.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;

class ItemRegistryTest {

	private int idItem = 63514896;
	private ItemRegistry itemRegistry;
	private List<ItemListDTO> itemList = new ArrayList<>();
	private SaleDTO sale;

	@BeforeEach
	void setUp() throws Exception {
		itemRegistry = new ItemRegistry();
	}

	@AfterEach
	void tearDown() throws Exception {
		itemRegistry = null;
	}

	@Test
	void testSearchItemInventoryItemIsValid() {
		ItemDTO itemYoghurt = new ItemDTO(63514896, "Yoghurt", 12, 6, 3);
		ItemDTO expectedResult = itemYoghurt;
		ItemDTO result = itemRegistry.searchItemInventory(idItem);
		assertEquals(expectedResult, result, "idItem is not valid");
	}

	@Test
	void testSearchItemInventoryItemIsNotValid() {
		idItem = 0;
		ItemDTO expectedResult = null;
		ItemDTO result = itemRegistry.searchItemInventory(idItem);
		assertEquals(expectedResult, result, "Items with null idItem are the same");
	}

	@Test
	void testSearchItemInventoryItemIdItemWithNegativeValue() {
		idItem = -10;
		ItemDTO expectedResult = null;
		ItemDTO result = itemRegistry.searchItemInventory(idItem);
		assertEquals(expectedResult, result, "idItem with a negative value is not null in the end of the search.");
	}

	@Test
	void testUpdateInventorySuccessfully() {
		itemList.add(new ItemListDTO(63514896, "Yoghurt", 1, 12, 0.72, 12.72));
		sale = new SaleDTO("2021-05-02", "11:48:20", 12, 0.72, 0.0, 12.72, itemList);
		itemRegistry.updateInventory(sale);
		ItemDTO expectedResult = new ItemDTO(63514896, "Yoghurt", 12, 6, 4);
		ItemDTO result = itemRegistry.getItems().get(0);
		assertEquals(expectedResult, result, "Quantity sold do not update");
	}

	@Test
	void testUpdateInventorySaleIsNull() {
		sale = null;
		ItemDTO expectedResult = null;
		ItemDTO result = itemRegistry.getItems().get(0);
		try {
			itemRegistry.updateInventory(sale);
		} catch (NullPointerException e) {
			result = null;
			assertEquals(expectedResult, result, "idItem with a negative value is not null in the end of the search.");
		}
	}

	@Test
	void testGetItems() {
		int result = itemRegistry.getItems().size();
		int expectedResult = 3;
		assertEquals(expectedResult, result, "Item register returns the wrong value");
	}

	@Test
	void testGetItemsIsNull() {
		itemRegistry = null;
		int result = 0;
		int expectedResult = 0;
		try {
			result = itemRegistry.getItems().size();
		} catch (NullPointerException e) {
			assertEquals(expectedResult, result, "Item register returns the wrong value");
		}
	}

}
