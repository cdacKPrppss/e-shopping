package eshopping.messages;

public class ResponseCartList {
	  private String id;  
	  private String name;
	  private String url;
	  private String type;
	  private int price;
	  private long size;
	  private int quantity;

	  
	  
	  public ResponseCartList() {
	
	}



	public ResponseCartList(String id, String name, String url, String type, int price, long size, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public long getSize() {
		return size;
	}



	public void setSize(long size) {
		this.size = size;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "ResponseCartList [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", price=" + price
				+ ", size=" + size + ", quantity=" + quantity + "]";
	}

	
	
	
}

