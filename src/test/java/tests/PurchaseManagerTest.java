package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Client;
import domain.Purchase;
import service.ClientManager;
import service.PurchaseManager;

public class PurchaseManagerTest {
	
	PurchaseManager purchaseManager = new PurchaseManager();
	private final static int PRICE = 5442;
	private final static String DATE = "2000-10-10";
	private final static long IDCLIENT = 6;
	
	ClientManager clientManager = new ClientManager();
	private final static String FIRSTNAME = "Jurek";
	private final static String LASTNAME = "Ziomek";
	private final static int PESEL = 12342331;
	
	@Test
	public void checkAdding(){
		long idClient;
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		clientManager.addClient(client);
		List<Client> clients = clientManager.getAllClients();
		idClient = clients.get(0).getId();
		
		Purchase purchase = new Purchase(PRICE,DATE,idClient);
		
		purchaseManager.deleteAllPurchases();
		assertEquals(1,purchaseManager.addPurchase(purchase));
		
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		Purchase purchaseRetrieved = purchases.get(0);
		
		assertEquals(PRICE, purchaseRetrieved.getPrice());
		assertEquals(DATE, purchaseRetrieved.getDate());
		assertEquals(idClient, purchaseRetrieved.getIdClient());
	}
	
	@Test
	public void checkDeletingAllPurchases(){
		long idClient;
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		clientManager.addClient(client);
		List<Client> clients = clientManager.getAllClients();
		idClient = clients.get(0).getId();
		
		Purchase purchase = new Purchase(PRICE,DATE,idClient);
		
		purchaseManager.addPurchase(purchase);
		purchaseManager.deleteAllPurchases();
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		assertEquals(0,purchases.size());
	}
	
	@Test
	public void checkDeletingAllPurchasesByClient(){
		Client idClient;
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		clientManager.addClient(client);
		List<Client> clients = clientManager.getAllClients();
		idClient = clients.get(0);
		
		Purchase purchase = new Purchase(PRICE,DATE,idClient.getId());
		
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.deleteAllPurchasesByClient(idClient);
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		assertEquals(0,purchases.size());
	}
	
	@Test
	public void checkGettingAllPurchases(){
		long idClient;
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		clientManager.addClient(client);
		List<Client> clients = clientManager.getAllClients();
		idClient = clients.get(0).getId();
		Purchase purchase = new Purchase(PRICE,DATE,idClient);
		
		purchaseManager.deleteAllPurchases();
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		
		List<Purchase> purchases = purchaseManager.getAllPurchases();
		assertEquals(5,purchases.size());
	}
	
	@Test
	public void checkGettingAllPurchasesByClient(){
		Client idClient;
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		clientManager.addClient(client);
		List<Client> clients = clientManager.getAllClients();
		idClient = clients.get(0);
		
		Purchase purchase = new Purchase(PRICE,DATE,idClient.getId());
		
		purchaseManager.deleteAllPurchases();
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		purchaseManager.addPurchase(purchase);
		
		List<Purchase> purchases = purchaseManager.getAllPurchasesByClient(idClient);
		assertEquals(5,purchases.size());
	}

}
