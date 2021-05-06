package main.java.se.anabelandrola.saleProcess.model;


/**
 * Contains information about one particular ItemListDTO.
 */
public class ItemListDTO {

	private final int idItem;
	private final String description;
	private final int quantity;
	private final double totalAmountWithoutVAT;
	private final double totalVAT;
	private final double totalAmountWithVAT;

	/**
	 * Creates a new instance representing a particular ItemList.
	 *
	 * @param idItem                The item's id.
	 * @param description           The item's name.
	 * @param quantity              The quantity of the item.
	 * @param totalAmountWithoutVAT The total amount without VAT.
	 * @param totalVAT              The total amount VAT.
	 * @param totalAmountWithVAT    The total amount with VAT.
	 */
	public ItemListDTO(int idItem, String description, int quantity, double totalAmountWithoutVAT, double totalVAT,
			double totalAmountWithVAT) {
		this.idItem = idItem;
		this.description = description;
		this.quantity = quantity;
		this.totalAmountWithoutVAT = totalAmountWithoutVAT;
		this.totalVAT = totalVAT;
		this.totalAmountWithVAT = totalAmountWithVAT;
	}
	/**
	 *  Represent ItemListDTO as a string
	 *
	 * @return ItemListDTO as a string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("idItem: " + idItem + ", ");
		builder.append("description: " + description + ", ");
		builder.append("quantity: " + quantity + ", ");
		builder.append("totalAmountWithoutVAT: " + totalAmountWithoutVAT + ", ");
		builder.append("totalVAT: " + totalVAT + ", ");
		builder.append("totalAmountWithVAT: " + totalAmountWithVAT + ", ");
		return builder.toString();
	}

	/**
	 * Get the value of idItem
	 *
	 * @return the value of idItem
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * Get the value of description
	 *
	 * @return the value of description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get the value of quantity
	 *
	 * @return the value of quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Get the value of totalAmountWithoutVAT
	 *
	 * @return the value of totalAmountWithoutVAT
	 */
	public double getTotalAmountWithoutVAT() {
		return totalAmountWithoutVAT;
	}

	/**
	 * Get the value of totalVAT
	 *
	 * @return the value of totalVAT
	 */
	public double getTotalVAT() {
		return totalVAT;
	}

	/**
	 * Get the value of totalAmountwithVAT
	 *
	 * @return the value of totalAmountwithVAT
	 */
	public double getTotalAmountWithVAT() {
		return totalAmountWithVAT;
	}
}
