package domain;

public class Purchase {

	private long id;
	private int price;
	private String date;
	private long idClient;
	
	public Purchase(){
		
	}
	
	public Purchase(int price, String date, long idClient){
		this.price = price;
		this.date = date;
		this.idClient = idClient;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	
}
