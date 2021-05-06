package main.java.se.anabelandrola.saleProcess.integration;


/**
 * Contains information about one particular item.
 */
public final class ItemDTO {

	private final int idItem;
	private final String description;
	private final double price;
	private final int VAT;
	private final int quantitySold;

	/**
	 * Creates a new instance representing a particular item.
	 *
	 * @param idItem       The item's id.
	 * @param description  The description of the item.
	 * @param price        The price of the item.
	 * @param VAT          The range of VAT of this item e.g <code>25</code> if the
	 *                     VAT is 25%.
	 * @param quantitySold The item's quantity that is sold.
	 */

	public ItemDTO(int idItem, String description, double price, int VAT, int quantitySold) {
		this.idItem = idItem;
		this.description = description;
		this.price = price;
		this.VAT = VAT;
		this.quantitySold = quantitySold;
	}
	/**
	 *  Represent ItemDTO as a string
	 *
	 * @return ItemDTO as a string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("idItem: " + idItem + ", ");
		builder.append("description: " + description + ", ");
		builder.append("price: " + price + ", ");
		builder.append("VAT: " + VAT + ", ");
		builder.append("quantitySold: " + quantitySold + ", ");
		return builder.toString();
	}

	/**
	 * Two <code>ItemDTO</code> instances are equal if all fields are equal.
	 *
	 * @param otherObjectItem The <code>ItemDTO</code> to compare with this
	 *                        <code>ItemDTO</code>.
	 * @return <code>true</code> if all fields in the specified <code>ItemDTO</code>
	 *         are equal to corresponding fields in this <code>ItemDTO</code>,
	 *         <code>false</code> if they are not.
	 */
	@Override
	public boolean equals(Object otherObjectItem) {
		if (otherObjectItem == null) {
			return false;
		}
		if (getClass() != otherObjectItem.getClass()) {
			return false;
		}
		final ItemDTO other = (ItemDTO) otherObjectItem;
		if (idItem != other.idItem) {
			return false;
		}
		if (!description.equals(other.description)) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		if (VAT != other.VAT) {
			return false;
		}
		if (quantitySold != other.quantitySold) {
			return false;
		}
		return true;
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
	 * Get the value of price
	 *
	 * @return the value of price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Get the value of VAT
	 *
	 * @return the value of VAT
	 */
	public int getVAT() {
		return VAT;
	}

	/**
	 * Get the value of quantity sold
	 *
	 * @return the value of quantitySold
	 */
	public int getQuantitySold() {
		return quantitySold;
	}

}
