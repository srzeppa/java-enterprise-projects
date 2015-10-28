package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import service.ConnectionManager;

public class ConnectionManagerTest {
	
	ConnectionManager connectionManager = new ConnectionManager();

	@Test
	public void checkConnection() {
		assertNotNull(connectionManager.getConnection());
	}

}
