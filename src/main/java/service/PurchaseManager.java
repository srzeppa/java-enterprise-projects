package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Purchase;

public class PurchaseManager {
	
	private final String CREATE_TABLE_PURCHASE = "CREATE TABLE purchase(id bigint GENERATED BY DEFAULT AS IDENTITY, price integer, date varchar(11), idclient bigint REFERENCES client(id) ON DELETE CASCADE)";
	private PreparedStatement addPurchaseStmt;
	private PreparedStatement deleteAllPurchasesStmt;
	private PreparedStatement getAllPurchasesStmt;
	private PreparedStatement getAllPurchasesByClientStmt;
	private PreparedStatement deleteAllPurchasesByClientStmt;
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connect;

	private Statement statement;
	
	public PurchaseManager(){
		try {
			connect = connectionManager.getConnection();
			statement = connect.createStatement();
	
			ResultSet rs = connect.getMetaData().getTables(null, null, null,null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Purchase".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
	
			if (!tableExists){
				statement.executeUpdate(CREATE_TABLE_PURCHASE);
			}
			
			addPurchaseStmt = connect.prepareStatement("INSERT INTO purchase (price, date, idclient) VALUES (?, ?, ?)");
			getAllPurchasesStmt = connect.prepareStatement("SELECT * FROM purchase");
			deleteAllPurchasesStmt = connect.prepareStatement("DELETE FROM purchase");
			getAllPurchasesByClientStmt = connect.prepareStatement("SELECT * FROM purchase WHERE idClient = ?");
			deleteAllPurchasesByClientStmt = connect.prepareStatement("DELETE FROM purchase WHERE idClient = ?");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public int addPurchase(Purchase purchase){
		int count = 0;
		try {
			addPurchaseStmt.setInt(1, purchase.getPrice());
			addPurchaseStmt.setString(2, purchase.getDate());
			addPurchaseStmt.setLong(3, purchase.getIdClient());
			
			count = addPurchaseStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void deleteAllPurchases(){
		try {
			deleteAllPurchasesStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllPurchasesByClient(long idClient){
		try {
			deleteAllPurchasesByClientStmt.setLong(1, idClient);
			deleteAllPurchasesByClientStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Purchase> getAllPurchases(){
		List<Purchase> purchases = new ArrayList<Purchase>();
		try {
			ResultSet rs = getAllPurchasesStmt.executeQuery();

			while (rs.next()) {
				Purchase pu = new Purchase();
				pu.setId(rs.getInt("id"));
				pu.setPrice(rs.getInt("price"));
				pu.setDate(rs.getString("date"));
				pu.setIdClient(rs.getInt("idclient"));
				purchases.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchases;
	}
	
	public List<Purchase> getAllPurchasesByClient(long idClient){
		List<Purchase> purchases = new ArrayList<Purchase>();
		try {
			getAllPurchasesByClientStmt.setLong(1, idClient);
			ResultSet rs = getAllPurchasesByClientStmt.executeQuery();

			while (rs.next()) {
				Purchase pu = new Purchase();
				pu.setId(rs.getInt("id"));
				pu.setPrice(rs.getInt("price"));
				pu.setDate(rs.getString("date"));
				pu.setIdClient(rs.getInt("idclient"));
				purchases.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchases;
	}

}
