package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import domain.Client;
import domain.Product;
import service.ProductManager;

public class ProductManagerTest {
	
	ProductManager productManager = new ProductManager();
	private final static String PRODUCTNAME = "buty";
	private final static int PRICE = 100;
	private final static String CATEGORY = "test category";
	private final static boolean ISAVAIABLE = true;
	
	@Test
	public void checkAdding(){
		Product product = new Product(PRODUCTNAME, PRICE, CATEGORY, ISAVAIABLE);
		
		productManager.deleteAllProducts();
		assertEquals(1,productManager.addProduct(product));
		
		List<Product> products = productManager.getAllProducts();
		Product productRetrieved = products.get(0);
		
		assertEquals(PRODUCTNAME, productRetrieved.getProductName());
		assertEquals(PRICE, productRetrieved.getPrice());
		assertEquals(CATEGORY, productRetrieved.getCategory());
		assertEquals(ISAVAIABLE, productRetrieved.getIsAvaiable());
	}
	
	@Test
	public void checkDeletingAllProducts(){
		Product product = new Product(PRODUCTNAME, PRICE, CATEGORY, ISAVAIABLE);
		
		productManager.addProduct(product);
		productManager.deleteAllProducts();
		List<Product> products = productManager.getAllProducts();
		assertEquals(0,products.size());
	}
	
	@Test
	public void checkGettingAllProducts(){
		Product product = new Product(PRODUCTNAME, PRICE, CATEGORY, ISAVAIABLE);
		
		productManager.addProduct(product);
		productManager.addProduct(product);
		productManager.addProduct(product);
		productManager.addProduct(product);
		productManager.addProduct(product);
		
		List<Product> products = productManager.getAllProducts();
		assertEquals(5,products.size());
	}

}
