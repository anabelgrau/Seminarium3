package main.java.se.anabelandrola.saleProcess.view;

import java.text.DecimalFormat;

import main.java.se.anabelandrola.saleProcess.controller.Controller;
import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;

public class View {

	private Controller control;

	/*
	 * Creates a new instance.
	 *
	 * @param control The controller that is used for all the operations.
	 */
	public View(Controller control) {
		this.control = control;
	}

	/*
	 * Stimulates a user's input that generates calls to all the system operations.
	 */
	public void sampleProcessSaleExecution() {
		DecimalFormat format = new DecimalFormat("#.##");

		// systemoperation startsale
		control.startSale();
		System.out.println("A new sale has been started.");

		// systemoperation registerItem
		int isIdItem = 43560294;
		int isIdItem2 = 57306946;
		int isNotIdItem = 63514810;
		ItemListDTO item = null;

		try {
			// if idItem is not valid
			item = control.registerItem(isNotIdItem);
		} catch (NullPointerException e) {
			System.out.println("Item with id:" + isNotIdItem + " is not valid. Try igen.");

		}
		item = control.registerItem(isIdItem);
		System.out.println("Item's description: " + item.getDescription() + " price: " + item.getTotalAmountWithoutVAT() + " Total price(incl. VAT): " + item.getTotalAmountWithVAT());
		item = control.registerItem(isIdItem2);
		System.out.println("Item's description: " + item.getDescription() + " price: " + item.getTotalAmountWithoutVAT() + " Total price(incl. VAT): " + item.getTotalAmountWithVAT());
		item = control.registerItem(isIdItem);
		System.out.println("Item's description: " + item.getDescription() + " price: " + item.getTotalAmountWithoutVAT() + " Total price(incl. VAT): " + item.getTotalAmountWithVAT());
		
		// systemoperation generateSale
		SaleDTO sale = control.generateSale();
		System.out.println("The sale is finished.");
		System.out.println("Total price of the sale is: " + format.format(sale.getAmountTotalWithVAT()));

		// systemoperation pay
		double paidAmount = 64;
		System.out.println("-------------Receipt------------");
		control.pay(paidAmount);
		System.out.println("--------------------------------");
	}

}
