package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Client;
import domain.Product;

public class ProductManager {


	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connect;
	private final String CREATE_TABLE_PRODUCT = "CREATE TABLE product(id bigint GENERATED BY DEFAULT AS IDENTITY, productName varchar(20), price integer, category varchar(20), isavaiable BOOLEAN)";
	private PreparedStatement addProductStmt;
	private PreparedStatement deleteAllProductsStmt;
	private PreparedStatement getAllProductsStmt;
	private PreparedStatement updateProductByIdStmt;
	private PreparedStatement deleteProductByIdStmt;

	private Statement statement;
	
	public ProductManager(){
		try {
			connect = connectionManager.getConnection();
			statement = connect.createStatement();
	
			ResultSet rs = connect.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("product".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
	
			if (!tableExists){
				statement.executeUpdate(CREATE_TABLE_PRODUCT);
			}
			
			addProductStmt = connect.prepareStatement("INSERT INTO product(productName,price,category,isavaiable) VALUES (?,?,?,?);");
			getAllProductsStmt = connect.prepareStatement("SELECT * FROM product;");
			deleteAllProductsStmt = connect.prepareStatement("DELETE FROM product;");
			updateProductByIdStmt = connect.prepareStatement("UPDATE product SET productname = ?, price = ?, category = ?, isavaiable = ? WHERE id = ?");
			deleteProductByIdStmt = connect.prepareStatement("DELETE FROM product WHERE id = ?");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteAllProducts(){
		try {
			deleteAllProductsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		try {
			ResultSet rs = getAllProductsStmt.executeQuery();

			while (rs.next()) {
				Product pr = new Product();
				pr.setId(rs.getInt("id"));
				pr.setProductName(rs.getString("productname"));
				pr.setPrice(rs.getInt("price"));
				pr.setCategory(rs.getString("category"));
				pr.setIsAvaiable(rs.getBoolean("isavaiable"));
				products.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public int addProduct(Product product){
		int count = 0;
		try {
			addProductStmt.setString(1, product.getProductName());
			addProductStmt.setInt(2, product.getPrice());
			addProductStmt.setString(3, product.getCategory());
			addProductStmt.setBoolean(4, product.getIsAvaiable());
			count = addProductStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateProductById(Product product){
		int count = 0;
		try {
			updateProductByIdStmt.setString(1, product.getProductName());
			updateProductByIdStmt.setInt(2, product.getPrice());
			updateProductByIdStmt.setString(3, product.getCategory());
			updateProductByIdStmt.setBoolean(4, product.getIsAvaiable());
			updateProductByIdStmt.setLong(5, product.getId());
			count = updateProductByIdStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void deleteProductById(Product idProduct){
		try {
			deleteProductByIdStmt.setLong(1, idProduct.getId());
			deleteProductByIdStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}