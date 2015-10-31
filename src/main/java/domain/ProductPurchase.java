package domain;

public class ProductPurchase {
	
	private long idProduct;
	private long idPurchase;
	private double summary=0;
	
	public ProductPurchase(){
		
	}
	
	public ProductPurchase(long idProduct, long idPurchase, double summary){
		this.idProduct = idProduct;
		this.idPurchase = idPurchase;
		this.summary = summary;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public long getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(long idPurchase) {
		this.idPurchase = idPurchase;
	}

	public double getSummary() {
		return summary;
	}

	public void setSummary(double summary) {
		this.summary = summary;
	}

}
