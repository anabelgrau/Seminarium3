package main.java.se.anabelandrola.saleProcess.model;

import java.text.DecimalFormat;

/**
 * The Receipt of the sale
 */
public class Receipt {

	private final Sale sale;

	/**
	 * Creates a new instance.
	 *
	 * @param sale The sale proved by this receipt.
	 */
	Receipt(Sale sale) {
		this.sale = sale;
	}

	/**
	 * Creates the entire content of the receipt.
	 *
	 * @return The receipt string.
	 */
	public String createReceipt() {
		DecimalFormat format = new DecimalFormat("#.##");

		StringBuilder builder = new StringBuilder();
		appendLine(builder, "Receipt");
		endSection(builder);

		builder.append("Sale date: ");
		appendLine(builder, sale.getSale().getDate());
		builder.append("Sale time: ");
		appendLine(builder, sale.getSale().getTime());
		endSection(builder);

		builder.append("Store's name: ICA, address: Fridhemsplan");
		endSection(builder);

		builder.append("List of items");
		endSection(builder);
		for (ItemListDTO item : sale.getSale().getItems()) {
			builder.append("Item's name:");
			appendLine(builder, item.getDescription());
			builder.append("Item's quantity:");
			appendLine(builder, item.getQuantity());
			builder.append("Item's price:");
			appendLine(builder, item.getTotalAmountWithVAT());
			endSection(builder);
		}

		builder.append("Total price: ");
		appendLine(builder, format.format(sale.getPayment().getTotalCost()));
		builder.append("VAT: ");
		appendLine(builder, format.format(sale.getSale().getAmountVAT()));
		endSection(builder);

		builder.append("Amount Paid: ");
		appendLine(builder, format.format(sale.getPayment().getPaidAmount()));
		builder.append("Change: ");

		// Get only 2 decimal points
		appendLine(builder, format.format(sale.getPayment().getChange()));
		endSection(builder);

		return builder.toString();
	}

	private void appendLine(StringBuilder builder, String line) {
		builder.append(line);
		builder.append("\n");
	}

	private void appendLine(StringBuilder builder, int line) {
		builder.append(line);
		builder.append("\n");
	}

	private void appendLine(StringBuilder builder, double line) {
		builder.append(line);
		builder.append("\n");
	}

	private void endSection(StringBuilder builder) {
		builder.append("\n");
	}

}
