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

public class ClientManager {

	private final String CREATE_TABLE_CLIENT = "CREATE TABLE client(id bigint GENERATED BY DEFAULT AS IDENTITY, firstname varchar(20), lastname varchar(20), pesel integer)";
	private PreparedStatement addClientStmt;
	private PreparedStatement deleteClientStmt;
	private PreparedStatement deleteAllClientsStmt;
	private PreparedStatement getAllClientStmt;
	private ConnectionManager connectionManager = new ConnectionManager();
	private Connection connect;

	private Statement statement;
	
	public ClientManager(){
		try {
			connect = connectionManager.getConnection();
			statement = connect.createStatement();
	
			ResultSet rs = connect.getMetaData().getTables(null, null, null,null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("client".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
	
			if (!tableExists){
				statement.executeUpdate(CREATE_TABLE_CLIENT);
			}
			
			addClientStmt = connect.prepareStatement("INSERT INTO client (firstname, lastname, pesel) VALUES (?, ?, ?)");
			deleteClientStmt = connect.prepareStatement("DELETE FROM client WHERE lastname = ?");
			getAllClientStmt = connect.prepareStatement("SELECT id,firstname,lastname,pesel FROM client");
			deleteAllClientsStmt = connect.prepareStatement("DELETE FROM client");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connect;
	}
	
	public int addClient(Client client){
		int count = 0;
		try {
			addClientStmt.setString(1, client.getFirstname());
			addClientStmt.setString(2, client.getLastname());
			addClientStmt.setInt(3, client.getPesel());
			
			count = addClientStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void deleteClient(Client client){
		try {
			deleteClientStmt.setString(1, client.getLastname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllClients(){
		try {
			deleteAllClientsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Client> getAllClients(){
		List<Client> clients = new ArrayList<Client>();
		try {
			ResultSet rs = getAllClientStmt.executeQuery();

			while (rs.next()) {
				Client cl = new Client();
				cl.setId(rs.getInt("id"));
				cl.setFirstname(rs.getString("firstname"));
				cl.setLastname(rs.getString("lastname"));
				cl.setPesel(rs.getInt("pesel"));
				clients.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
}
