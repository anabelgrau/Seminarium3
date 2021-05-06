package main.java.se.anabelandrola.saleProcess.integration;

import main.java.se.anabelandrola.saleProcess.model.SaleDTO;
import main.java.se.anabelandrola.saleProcess.model.ItemListDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains information about the accounting registry.
 */
public class AccountingRegistry {
	private List<AccountingData> accounting = new ArrayList<>();

	AccountingRegistry() {

	}

	/**
	 * Updates information about a sale in AccountingRegistry.
	 *
	 * @param sale This contains information about the sale that has the list of
	 *             items.
	 */
	public void updateAccounting(SaleDTO sale) {
		accounting.add(new AccountingData(sale.getDate(), sale.getAmountTotalWithVAT(), sale.getItems()));
	}

	/**
	 * Get the value of AccountingRegistry.
	 *
	 * @return the value of AccountingRegistry
	 */
	public List<AccountingData> getAccountingRegistry() {
		return accounting;
	}

	private static class AccountingData {
		private String date;
		private double amountTotalWithVAT;
		private List<ItemListDTO> items;

		public AccountingData(String date, double amountTotalWithVAT, List<ItemListDTO> items) {
			this.date = date;
			this.amountTotalWithVAT = amountTotalWithVAT;
			this.items = items;
		}

	}
}
