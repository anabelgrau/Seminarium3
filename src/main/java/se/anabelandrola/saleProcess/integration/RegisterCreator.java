package main.java.se.anabelandrola.saleProcess.integration;

/**
 * This class is responsible for instantiating registers.
 */
public class RegisterCreator {

	private SaleRegister saleRegister = new SaleRegister();
	
	/**
	 * Get the value of SaleRegister
	 *
	 * @return the value of SaleRegister
	 */
	public SaleRegister getSaleRegister() {
		return saleRegister;
	}
}
