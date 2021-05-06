package main.java.se.anabelandrola.saleProcess.integration;

import main.java.se.anabelandrola.saleProcess.model.Receipt;

/**
 * The interface for the printer
 */

public class Printer {

	/**
	 * Prints the specified receipt. This dummy implementation prints to
	 * <code>System.out</code> instead of a printer.
	 *
	 * @param receipt. The receipt that will be printed.
	 */
	public void printReceipt(Receipt receipt) {
		System.out.println(receipt.createReceipt());
	}

}
