package main.java.se.anabelandrola.saleProcess.integration;

import main.java.se.anabelandrola.saleProcess.model.SaleDTO;
import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains information about the Sale Register.
 */
public class SaleRegister {
	private List<SaleData> saleReg = new ArrayList<>();
	private ItemRegistry itemRegistry;
	private AccountingRegistry accountingRegistry;

	SaleRegister() {
		this.itemRegistry = new ItemRegistry();
		this.accountingRegistry = new AccountingRegistry();
	}

	/**
	 * Get the value of ItemRegistry
	 *
	 * @return the value of ItemRegistry
	 */
	public ItemRegistry getItemRegistry() {
		return itemRegistry;
	}

	/**
	 * Get the value of AccountingRegistry
	 *
	 * @return the value of AccountingRegistry
	 */
	public AccountingRegistry getAccountingRegistry() {
		return accountingRegistry;
	}

	/**
	 * registers a sale and updates AccountingRegistry and Itemregistry
	 * 
	 * @param sale contains information about the sale
	 */
	public void registerSale(SaleDTO sale) {
		saleReg.add(new SaleData(sale.getDate(), sale.getTime(), sale.getAmountSale(), sale.getAmountVAT(),
				sale.getAmountDiscount(), sale.getAmountTotalWithVAT(), sale.getItems()));
		this.accountingRegistry.updateAccounting(sale);
		this.itemRegistry.updateInventory(sale);
	}

	/**
	 * Get the list of saleRegister
	 *
	 * @return the list of saleRegister
	 */
	public List<SaleDTO> getSaleRegister() {
		List<SaleDTO> saleRegist =  new ArrayList<>();
		for (SaleData sale : saleReg) 
			saleRegist.add(new SaleDTO(sale.date, sale.time,sale.amountSale,sale.amountVAT,sale.amountDiscount,sale.amountTotalwithVAT,sale.items));	
		return saleRegist;
	}

	private static class SaleData {

		private final String date;
		private final String time;
		private final double amountSale;
		private final double amountVAT;
		private final double amountDiscount;
		private final double amountTotalwithVAT;
		private final List<ItemListDTO> items;

		public SaleData(String date, String time, double amountSale, double amountVAT, double amountDiscount,
				double amountTotalwithVAT, List<ItemListDTO> items) {
			this.date = date;
			this.time = time;
			this.amountSale = amountSale;
			this.amountVAT = amountVAT;
			this.amountDiscount = amountDiscount;
			this.amountTotalwithVAT = amountTotalwithVAT;
			this.items = items;
		}
	}
}
