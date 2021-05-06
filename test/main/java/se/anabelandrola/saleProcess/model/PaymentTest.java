package main.java.se.anabelandrola.saleProcess.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTest {
	private Payment pay;
	double paidAmount = 0;
	private List<ItemListDTO> itemList = new ArrayList<>();
	private SaleDTO sale;
	
	@BeforeEach
	void setUp() throws Exception {
		paidAmount = 40;
		pay = new Payment(paidAmount);
		itemList.add (new ItemListDTO (63514896, "Yoghurt",1, 12, 0.72,12.72));    
		sale = new SaleDTO("2021-05-02","11:48:20",12,0.72,0.0,12.72,itemList);
	}

	@AfterEach
	void tearDown() throws Exception {
		pay = null;
		itemList = null;
		sale = null;
	}
	@Test
	void testCalculateTotalAmountSuccessfully() {
		pay.calculateTotalAmount(sale);
		double expectedResult = sale.getAmountTotalWithVAT();
		double result = pay.getTotalCost();
		assertEquals(expectedResult,result,"Total amount is incorrect");
	}
	@Test
	void testCalculateTotalAmountSaleIsNull() {
		sale = null;
		try {
		pay.calculateTotalAmount(sale);
		}catch(NullPointerException e)
		{
		double expectedResult = 0;
		double result = pay.getTotalCost();
		assertEquals(expectedResult,result,"Total amount is incorrect");
		}
	}
	@Test
	void testGetChangeSuccessfully() {
		pay.calculateTotalAmount(sale);
		double expectedResult = 27.28;
		double result = pay.getChange();
		assertEquals(expectedResult,result,"Change is incorrect");
	}
	@Test
	void testGetChangeAmountPaidIsZero() {
		paidAmount = 0;
		pay = new Payment(paidAmount);
		pay.calculateTotalAmount(sale);
		double expectedResult = 0;
		double result = pay.getChange();
		assertEquals(expectedResult,result,"Change has a value different from zero");
	}

}
