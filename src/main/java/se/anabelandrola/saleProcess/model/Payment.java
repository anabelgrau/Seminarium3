package main.java.se.anabelandrola.saleProcess.model;

/**
 * Represents one specific payment for one specific sale. The sale is payed with
 * cash.
 */

public class Payment {

	private double paidAmount;
	private double totalCost;

	/**
	 * Creates a new instance. The customer hands over the specified amount.
	 *
	 * @param paidAmount The amount of cash that was handed over by the customer.
	 */
	public Payment(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * Calculates the total cost of the specified sale.
	 * 
	 * @param sale The sale for which the customer is paying.
	 */
	void calculateTotalAmount(SaleDTO sale) {
		totalCost = sale.getAmountTotalWithVAT();
	}

	/**
	 * Get the value of totalCost
	 * 
	 * @return The total cost of the sale that was paid.
	 */
	double getTotalCost() {
		return totalCost;
	}

	/**
	 * Get the value of paidAmount
	 * 
	 * @return The amount paid.
	 */
	double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * Get the value of the change
	 * 
	 * @return The amount of change the customer shall have.
	 */
	double getChange() {
		double change = 0;
		if (paidAmount >= totalCost) {
			change = paidAmount - totalCost;
		}
		return change;
	}

}
