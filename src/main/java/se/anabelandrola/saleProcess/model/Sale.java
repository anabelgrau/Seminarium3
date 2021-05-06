package main.java.se.anabelandrola.saleProcess.model;

import java.util.Calendar;
import java.util.List;
import java.time.LocalDate;

import main.java.se.anabelandrola.saleProcess.integration.ItemDTO;
import main.java.se.anabelandrola.saleProcess.integration.Printer;

/**
 * Represents one specific sale.
 */
public class Sale {
	private SaleDTO sale;
	private ItemList itemList;
	private Payment pay;

	public Sale() {
		this.itemList = new ItemList();

	}

	/**
	 * register all the items for the actual sale.
	 *
	 * @param foundItem The item that will be registered.
	 * @return the item has been registered
	 */
	public ItemListDTO registerItem(ItemDTO foundItem) throws NullPointerException {
		if (foundItem == null)
			throw new NullPointerException("idItem is not valid");
		boolean existItem = itemList.searchItemList(foundItem);
		if (!existItem)
			itemList.saveItem(foundItem);
		else
			itemList.increaseQuantity(foundItem);
		return itemList.getItemList(foundItem);
	}

	/**
	 * Saves the sale.
	 */
	public SaleDTO saveSale() {
		String date = this.getDate();
		String time = this.getTime();
		List<ItemListDTO> listItem = itemList.getItemList();
		double amountSale = 0;
		double amountVAT = 0;
		double amountDiscount = 0;
		double amountTotalWithVAT = 0;
		for (ItemListDTO item : listItem) {
			amountSale += item.getTotalAmountWithoutVAT();
			amountVAT += item.getTotalVAT();
			amountTotalWithVAT += item.getTotalAmountWithVAT();
		}
		this.sale = new SaleDTO(date, time, amountSale, amountVAT, amountDiscount, amountTotalWithVAT, listItem);
		return sale;
	}

	/**
	 * This gets the date
	 * 
	 * @return the value of the date
	 */
	private String getDate() {
		LocalDate dateLD = LocalDate.now();
		String date = dateLD.toString();
		return date;
	}

	/**
	 * This gets the date
	 * 
	 * @return the value of the date
	 */
	private String getTime() {
		Calendar c = Calendar.getInstance();
		String time = (Integer.toString(c.get(Calendar.HOUR_OF_DAY))) + ":" + (Integer.toString(c.get(Calendar.MINUTE)))
				+ ":" + (Integer.toString(c.get(Calendar.SECOND)));
		return time;
	}

	/**
	 * This sale is paid using the specified payment.
	 * 
	 * @param pay The payment used to pay this sale.
	 */
	public void pay(Payment pay) throws IllegalArgumentException {
		pay.calculateTotalAmount(sale);
		if (pay.getPaidAmount() < pay.getTotalCost())
			throw new IllegalArgumentException("The amount paid is less than the total cost of the sale");
		this.pay = pay;
	}

	/**
	 * This returns payment.
	 * 
	 * @return pay the value of pay
	 */
	public Payment getPayment() {
		return pay;
	}

	/**
	 * This returns sale.
	 * 
	 * @return the value of sale
	 */
	public SaleDTO getSale() {
		return sale;
	}

	/**
	 * Prints a receipt for the current sale on the specified printer.
	 * 
	 * @param printer The printer where the receipt is printed.
	 */
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(this);
		printer.printReceipt(receipt);
	}

}
