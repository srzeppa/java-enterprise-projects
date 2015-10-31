package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductPurchaseManager {

	private final String CREATE_TABLE_PRODUCTPURCHASE = "CREATE TABLE productpurchase(idproduct bigint REFERENCES product(id) ON DELETE CASCADE, idpurchase bigint REFERENCES purchase(id) ON DELETE CASCADE)";
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
			}
			
			addProductPurchaseStmt = connect.prepareStatement("INSERT INTO productpurchase (price, date, idclient) VALUES (?, ?, ?)");
			getAllPurchasesStmt = connect.prepareStatement("SELECT * FROM purchase");
			deleteAllProductPurchasesStmt = connect.prepareStatement("DELETE FROM purchase");
			getAllProductsByPurchasesStmt = connect.prepareStatement("SELECT * FROM purchase WHERE idClient = ?");
			deleteAllProductPurchasesStmt = connect.prepareStatement("DELETE FROM purchase WHERE idClient = ?");
			getAllPurchasesByProductStmt = connect.prepareStatement("SELECT * FROM purchase WHERE idClient = ?");
			deleteAllPurchasesByProductStmt = connect.prepareStatement("DELETE FROM purchase WHERE idClient = ?");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
}
