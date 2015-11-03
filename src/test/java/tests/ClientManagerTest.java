package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import domain.Client;
import service.ClientManager;

public class ClientManagerTest {
	
	ClientManager clientManager = new ClientManager();
	private final static String FIRSTNAME = "Jurek";
	private final static String LASTNAME = "Ziomek";
	private final static int PESEL = 12342331;
	
	private final static String UPDATEDFIRSTNAME = "Zbyniu";
	private final static String UPDATEDLASTNAME = "Bubel";
	private final static int UPDATEDPESEL = 999999;
	
	@Test
	public void checkAdding(){
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		
		clientManager.deleteAllClients();
		assertEquals(1,clientManager.addClient(client));
		
		List<Client> clients = clientManager.getAllClients();
		Client clientRetrieved = clients.get(0);
		
		assertEquals(FIRSTNAME, clientRetrieved.getFirstname());
		assertEquals(LASTNAME, clientRetrieved.getLastname());
		assertEquals(PESEL, clientRetrieved.getPesel());
	}
	
	@Test
	public void checkDeletingAllClients(){
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		
		clientManager.addClient(client);
		clientManager.deleteAllClients();
		List<Client> clients = clientManager.getAllClients();
		assertEquals(0,clients.size());
	}
	
	@Test
	public void checkGettingAllClients(){
		Client client = new Client(FIRSTNAME, LASTNAME, PESEL);
		
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		
		List<Client> clients = clientManager.getAllClients();
		assertEquals(5,clients.size());
	}
	
	@Test
	public void checkUpdateClient(){
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME, LASTNAME, PESEL);
		Client clientForUpdate = new Client(UPDATEDFIRSTNAME,UPDATEDLASTNAME,UPDATEDPESEL);
		long id;
		String firstname, firstnameAfterUpdate;
		String lastname, lastnameAfterUpdate;
		int pesel, peselAfterUpdate;
		
		clientManager.addClient(client);
		List<Client> clientBeforeUpdate = clientManager.getAllClients();
		id = clientBeforeUpdate.get(0).getId();
		firstname = clientBeforeUpdate.get(0).getFirstname();
		lastname = clientBeforeUpdate.get(0).getLastname();
		pesel = clientBeforeUpdate.get(0).getPesel();
		
		
		clientManager.updateClientById(clientForUpdate, id);
		List<Client> clientAfterUpdate = clientManager.getAllClients();
		firstnameAfterUpdate = clientAfterUpdate.get(0).getFirstname();
		lastnameAfterUpdate = clientAfterUpdate.get(0).getLastname();
		peselAfterUpdate = clientAfterUpdate.get(0).getPesel();
		
		assertNotSame(firstname, firstnameAfterUpdate);
		assertNotSame(lastname, lastnameAfterUpdate);
		assertNotSame(pesel, peselAfterUpdate);
	}
	
	@Test
	public void checkDeletetingClientById(){
		clientManager.deleteAllClients();
		Client client = new Client(FIRSTNAME, LASTNAME, PESEL);
		long id1, id2, id3;
		
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		
		List<Client> clients = clientManager.getAllClients();
		id1 = clients.get(0).getId();
		id2 = clients.get(1).getId();
		id3 = clients.get(2).getId();
		
		clientManager.deleteClientById(id1);
		clientManager.deleteClientById(id2);
		clientManager.deleteClientById(id3);
		
		clients = clientManager.getAllClients();
		assertEquals(0,clients.size());
	}
}
