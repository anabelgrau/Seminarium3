package main.java.se.anabelandrola.saleProcess.model;

/**
 * Represents a cash register.
 */

public class CashRegister {
	private double amount;

	/**
	 * Increases the cash amount in the register.
	 * 
	 * @param pay contains information about the total cost of the sale
	 */
	public void increasesAmount(Payment pay) {
		amount += pay.getTotalCost();
	}

	/**
	 * Increases the cash amount in the register.
	 * 
	 * @return amount of the sale's total cost
	 */
	public double getAmount() {
		return amount;
	}
}
