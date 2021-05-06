package main.java.se.anabelandrola.saleProcess.model;

import main.java.se.anabelandrola.saleProcess.integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list for all the registered item
 */

public class ItemList {

	private List<ItemListData> listItems = new ArrayList<>();

	public ItemList() {

	}

	/**
	 * save the item in the list.
	 *
	 * @param foundItem The item that was found.
	 */
	public void saveItem(ItemDTO foundItem) {

		listItems.add(new ItemListData(foundItem.getIdItem(), foundItem.getDescription(), 1, foundItem.getPrice(),
				foundItem.getVAT() * foundItem.getPrice() / 100,
				foundItem.getPrice() + foundItem.getVAT() * foundItem.getPrice() / 100));
	}

	/**
	 * Search for an item in the item list
	 *
	 * @param founditem The item that was found in the item list.
	 */
	public boolean searchItemList(ItemDTO foundItem) {
		for (ItemListData item : listItems) {
			if (item.idItem == foundItem.getIdItem()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Increases the quantity of the item in the list.
	 *
	 * @param founditem The item that increase quantity.
	 */
	public void increaseQuantity(ItemDTO foundItem) {
		for (ItemListData item : listItems) {
			if (item.idItem == foundItem.getIdItem()) {
				item.quantity++;
				item.totalAmountWithoutVAT = item.quantity * foundItem.getPrice();
				item.totalVAT = (foundItem.getVAT() * foundItem.getPrice() / 100) * item.quantity;
				item.totalAmountWithVAT = item.totalAmountWithoutVAT + item.totalVAT;
			}
			break;
		}
	}

	/**
	 * Get the value of a specific item in itemList.
	 * @param foundItem The item's information
	 * @return the value of the item in itemList
	 */
	public ItemListDTO getItemList(ItemDTO foundItem) {
		ItemListDTO itemList = null;
		for (ItemListData item : listItems) {
			if (item.idItem == foundItem.getIdItem()) {
				itemList = new ItemListDTO(item.idItem, item.description, item.quantity, item.totalAmountWithoutVAT,
						item.totalVAT, item.totalAmountWithVAT);
				break;
			}
		}
		return itemList;
	}

	/**
	 * Get the value of the itemList
	 *
	 * @return the value of the itemList
	 */
	public List<ItemListDTO> getItemList() {
		List<ItemListDTO> itemList = new ArrayList<>();
		for (ItemListData item : listItems) {
			itemList.add(new ItemListDTO(item.idItem, item.description, item.quantity, item.totalAmountWithoutVAT,
					item.totalVAT, item.totalAmountWithVAT));
		}
		return itemList;
	}

	private static class ItemListData {

		private int idItem;
		private String description;
		private int quantity;
		private double totalAmountWithoutVAT;
		private double totalVAT;
		private double totalAmountWithVAT;

		public ItemListData(int idItem, String description, int quantity, double totalAmountWithoutVAT, double totalVAT,
				double totalAmountWithVAT) {
			this.idItem = idItem;
			this.description = description;
			this.quantity = quantity;
			this.totalAmountWithoutVAT = totalAmountWithoutVAT;
			this.totalVAT = totalVAT;
			this.totalAmountWithVAT = totalAmountWithVAT;
		}
	}

}
