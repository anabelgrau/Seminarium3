package main.java.se.anabelandrola.saleProcess.controller;

import main.java.se.anabelandrola.saleProcess.integration.ItemRegistry;
import main.java.se.anabelandrola.saleProcess.integration.AccountingRegistry;
import main.java.se.anabelandrola.saleProcess.integration.RegisterCreator;
import main.java.se.anabelandrola.saleProcess.integration.SaleRegister;
import main.java.se.anabelandrola.saleProcess.integration.ItemDTO;
import main.java.se.anabelandrola.saleProcess.integration.Printer;
import main.java.se.anabelandrola.saleProcess.model.CashRegister;
import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import main.java.se.anabelandrola.saleProcess.model.Sale;
import main.java.se.anabelandrola.saleProcess.model.SaleDTO;
import main.java.se.anabelandrola.saleProcess.model.Payment;


public class Controller {

	private ItemRegistry itemRegistry;
	private AccountingRegistry accountingRegistry;
	private SaleRegister saleRegister;
	private Printer printer;
	private Sale sale;
	private CashRegister cashRegister;

	/**
	 * Creates a new instance.
	 *
	 * @param registerCreator Used to get classes that handle database calls.
	 * @param printer         Interface to printer.
	 */
	public Controller(RegisterCreator registerCreator, Printer printer) {
		this.itemRegistry = registerCreator.getSaleRegister().getItemRegistry();
		this.accountingRegistry = registerCreator.getSaleRegister().getAccountingRegistry();
		this.saleRegister = registerCreator.getSaleRegister();
		this.printer = printer;
		this.cashRegister = new CashRegister();

	}

	/**
	 * Start a new sale.
	 */
	public void startSale() {
		this.sale = new Sale();
	}

	/**
	 * Registers an item in the list of items for sale.
	 *
	 * @param idItem This contains the identifier of the item.
	 * @return The item's information
	 * 
	 */
	public ItemListDTO registerItem(int idItem) throws IllegalArgumentException {
		ItemDTO foundItem = itemRegistry.searchItemInventory(idItem);
		ItemListDTO item = sale.registerItem(foundItem);
		return item;
	}

	/**
	 * Generates a sale.
	 * 
	 * @return The sale's information
	 */
	public SaleDTO generateSale() {
		SaleDTO saleGen = sale.saveSale();
		return saleGen;
	}

	/**
	 * Handles sale payment. Calculates change. Updates the sale of the sale
	 * register and updates the external system item registry and the accounting
	 * registry. Prints the receipt.
	 *
	 * @param paidAmount The paid amount.
	 */
	public void pay(double paidAmount) {
		Payment pay = new Payment(paidAmount);
		sale.pay(pay);
		cashRegister.increasesAmount(pay);
		SaleDTO saleD = sale.getSale();
		saleRegister.registerSale(saleD);
		sale.printReceipt(printer);
	}

	/**
	 * Get the value of amount in CashRegister
	 *
	 * @return the value of amount in CashRegister
	 */
	public double getAmountCashRegister() {
		return cashRegister.getAmount();
	}

}
