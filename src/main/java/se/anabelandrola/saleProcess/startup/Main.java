package main.java.se.anabelandrola.saleProcess.startup;

import main.java.se.anabelandrola.saleProcess.integration.RegisterCreator;
import main.java.se.anabelandrola.saleProcess.integration.Printer;
import main.java.se.anabelandrola.saleProcess.controller.Controller;
import main.java.se.anabelandrola.saleProcess.view.View;

/**
 * Contains the main method. Performs all the startups of the application.
 */
public class Main {
	/**
	 * Starts the application.
	 *
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		RegisterCreator creator = new RegisterCreator();
		Printer printer = new Printer();
		Controller control = new Controller(creator, printer);
		new View(control).sampleProcessSaleExecution();
	}
}