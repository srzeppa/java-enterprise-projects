package domain;

public class Product {

	private long id;
	private String productName;
	private int price;
	private String category;
	private boolean isAvaiable;
	
	public Product(){
		
	}
	
	public Product(String productName, int price, String category, boolean isAvaiable){
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.isAvaiable = isAvaiable;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setIsAvaiable(boolean isAvaiable){
		this.isAvaiable = isAvaiable;
	}
	public boolean getIsAvaiable(){
		return isAvaiable;
	}
}
