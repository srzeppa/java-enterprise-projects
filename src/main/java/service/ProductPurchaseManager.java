package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductPurchaseManager {

	private final String ALTER_TABLE_PRODUCT_PURCHASE = "ALTER TABLE ProductPurchase ADD COINSTRAINT idProductfk FOREIGN KEY (idproduct) REFERENCES product(id) ON DELETE CASCADE";
	private final String ALTER_TABLE_PRODUCT_PURCHASE2 = "ALTER TABLE ProductPurchase ADD COINSTRAINT idPurchasefk FOREIGN KEY (idpurchase) REFERENCES purchase(id) ON DELETE CASCADE";
	private final String CREATE_TABLE_PRODUCTPURCHASE = "CREATE TABLE productpurchase(idproduct bigint, idpurchase bigint)";
	private PreparedStatement addProductPurchaseStmt;
	private PreparedStatement deleteAllProductPurchasesStmt;
	private PreparedStatement getAllPurchasesStmt;
	private PreparedStatement getAllPurchasesByProductStmt;
	private PreparedStatement deleteAllPurchasesByProductStmt;
	private PreparedStatement deleteAllProductsByPurchasesStmt;
	private PreparedStatement getAllProductsByPurchasesStmt;
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connect;

	private Statement statement;
	
	public ProductPurchaseManager(){
		try {
			connect = connectionManager.getConnection();
			statement = connect.createStatement();
	
			ResultSet rs = connect.getMetaData().getTables(null, null, null,null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("productpurchase".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
	
			if (!tableExists){
				statement.executeUpdate(CREATE_TABLE_PRODUCTPURCHASE);
				statement.executeUpdate(ALTER_TABLE_PRODUCT_PURCHASE);
				statement.executeUpdate(ALTER_TABLE_PRODUCT_PURCHASE2);
			}
			
			addProductPurchaseStmt = connect.prepareStatement("INSERT INTO productpurchase (idproduct, idpurchase, summary) VALUES (?, ?, ?)");
			getAllPurchasesStmt = connect.prepareStatement("SELECT * FROM productpurchase");
			deleteAllProductPurchasesStmt = connect.prepareStatement("DELETE FROM productpurchase");
			getAllProductsByPurchasesStmt = connect.prepareStatement("SELECT * FROM productpurchase WHERE idpurchase = ?");
			deleteAllProductPurchasesStmt = connect.prepareStatement("DELETE FROM productpurchase WHERE idpurchase = ?");
			getAllPurchasesByProductStmt = connect.prepareStatement("SELECT * FROM productpurchase WHERE idproduct = ?");
			deleteAllPurchasesByProductStmt = connect.prepareStatement("DELETE FROM productpurchase WHERE idproduct = ?");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public int addProductPurchase(){
		int count = 0;
		return count;
	}
	
	public void getAllPurchases(){
		
	}
	
	public void getAllPurchasesByProduct(){
		
	}
	
	public void getAllProductsByPurchase(){
		
	}
	
	public void deleteAllProductPurchases(){
		try {
			deleteAllProductPurchasesStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllPurchasesByProduct(){
		
	}
	
	public void deleteAllProductsByPurchase(){
		
	}
	
}
