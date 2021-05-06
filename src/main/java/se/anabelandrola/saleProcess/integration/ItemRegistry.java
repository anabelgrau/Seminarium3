package main.java.se.anabelandrola.saleProcess.integration;

import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains information about the inventory system.
 */
public class ItemRegistry {
	private List<ItemData> items = new ArrayList<>();

	ItemRegistry() {
		addItems();
	}

	private void addItems() {
		items.add(new ItemData(63514896, "Yoghurt", 12, 6, 3));
		items.add(new ItemData(43560294, "Milk", 10, 6, 2));
		items.add(new ItemData(57306946, "Beans", 32, 12, 3));

	}

	/**
	 * Search for an Item in the item registry.
	 *
	 * @param idItem This contains identifier of the item.
	 * @return Item if the item is in the ItemInventory or null if the item is not in
	 *         itemRegistry
	 */

	public ItemDTO searchItemInventory(int idItem) {
		for (ItemData item : items) {
			if (item.idItem == idItem) {
				return new ItemDTO(item.idItem, item.description, item.price, item.VAT, item.quantitySold);
			}
		}
		return null;
	}

	/**
	 * Update information about an item in the item registry.
	 *
	 * @param sale This contains information about the sale that has the list of items.
	 */
	public void updateInventory(SaleDTO sale) {
		for (ItemListDTO itemS : sale.getItems()) {
			for (ItemData item : items) {
				if (itemS.getIdItem() == item.idItem) {
					item.quantitySold = itemS.getQuantity()+item.quantitySold;

				}
				break;
			}
		}
	}
	/**
	 * Get the value of items
	 *
	 * @return the value of  items
	 */
	public List<ItemDTO> getItems()
	{	
		List<ItemDTO> itemsList =  new ArrayList<>();
		for (ItemData item : items) 
			itemsList.add(new ItemDTO(item.idItem,item.description,item.price,item.VAT,item.quantitySold));	
		return itemsList;
	}
	
	private static class ItemData {
		private int idItem;
		private String description;
		private double price;
		private int VAT;
		private int quantitySold;

		public ItemData(int idItem, String description, double price, int VAT, int quantitySold) {
			this.idItem = idItem;
			this.description = description;
			this.price = price;
			this.VAT = VAT;
			this.quantitySold = quantitySold;
		}

	}
}
