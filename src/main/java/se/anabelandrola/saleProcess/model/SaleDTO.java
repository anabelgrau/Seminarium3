package main.java.se.anabelandrola.saleProcess.model;


import java.util.List;

/**
 * Contains information about one particular sale.
 */
public final class SaleDTO {

	private final String date;
	private final String time;
	private final double amountSale;
	private final double amountVAT;
	private final double amountDiscount;
	private final double amountTotalWithVAT;
	private final List<ItemListDTO> items;

	/**
	 * Creates a new instance representing a particular item.
	 *
	 * @param date               The date when the sale was done.
	 * @param time               The time when the sale was done.
	 * @param amountSale         The amount of the sale.
	 * @param amountDiscount     The amount of discount the id provides.
	 * @param amountTotalWithVAT The amount with VAT included.
	 * @param items              The list of all the registered items.
	 */

	public SaleDTO(String date, String time, double amountSale, double amountVAT, double amountDiscount,
			double amountTotalWithVAT, List<ItemListDTO> items) {
		this.date = date;
		this.time = time;
		this.amountSale = amountSale;
		this.amountVAT = amountVAT;
		this.amountDiscount = amountDiscount;
		this.amountTotalWithVAT = amountTotalWithVAT;
		this.items = items;
	}
	/**
	 * Represent SaleDTO as a string
	 *
	 * @return SaleDTO as a string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("date: " + date + ", ");
		builder.append("time: " + time + ", ");
		builder.append("amountSale " + amountSale + ", ");
		builder.append("amountVAT: " + amountVAT + ", ");
		builder.append("amountDiscount: " + amountDiscount + ", ");
		builder.append("amountTotalWithVAT " + amountTotalWithVAT + ", ");
		builder.append("items " + items.toString() + ", ");
		return builder.toString();
	}

	/**
	 * Get the value of date
	 *
	 * @return the value of date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Get the value of time
	 *
	 * @return the value of time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Get the value of amountSale
	 *
	 * @return the value of amountSale
	 */
	public double getAmountSale() {
		return amountSale;
	}

	/**
	 * Get the value of amountDiscount
	 *
	 * @return the value of amountDiscount
	 */
	public double getAmountDiscount() {
		return amountDiscount;
	}

	/**
	 * Get the value of amountVAT
	 *
	 * @return the value of amountVAT
	 */
	public double getAmountVAT() {
		return amountVAT;
	}

	/**
	 * Get the value of amountTotalWithVAT
	 *
	 * @return the value of amountTotalWithVAT
	 */
	public double getAmountTotalWithVAT() {
		return amountTotalWithVAT;
	}

	/**
	 * Get the value of items
	 *
	 * @return the value of items
	 */
	public List<ItemListDTO> getItems() {
		return items;
	}
}
