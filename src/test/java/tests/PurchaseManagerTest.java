package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Purchase;
import service.PurchaseManager;

public class PurchaseManagerTest {
	
	PurchaseManager purchaseManager = new PurchaseManager();
	private final static int PRICE = 5442;
	private final static String DATE = "2000-10-10";
	private final static long IDCLIENT = 6;
	
	@Test
	public void checkAdding(){
		Purchase purchase = new Purchase(PRICE,DATE,IDCLIENT);
		
		purchaseManager.deleteAllPurchases();
		assertEquals(1,purchaseManager.addPurchase(purchase));
		
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		Purchase purchaseRetrieved = purchases.get(0);
		
		assertEquals(PRICE, purchaseRetrieved.getPrice());
		assertEquals(DATE, purchaseRetrieved.getDate());
		assertEquals(IDCLIENT, purchaseRetrieved.getIdClient());
	}
	
	@Test
	public void checkDeletingAllPurchases(){
		Purchase purchase = new Purchase(PRICE,DATE,IDCLIENT);
		
		purchaseManager.addPurchase(purchase);
		purchaseManager.deleteAllPurchases();
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		assertEquals(0,purchases.size());
	}
	
	@Test
	public void checkGettingAllPurchases(){
		Purchase purchase = new Purchase(PRICE,DATE,IDCLIENT);
		
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		assertEquals(5,purchases.size());
	}

}
