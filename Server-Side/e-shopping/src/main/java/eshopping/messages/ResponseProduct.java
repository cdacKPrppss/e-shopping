package eshopping.messages;

public class ResponseProduct {
	private String id;  
	  private String name;
	  private String url;
	  private String type;
	  private int price;
	  private long size;

	  
	  
	  public ResponseProduct() {
	
	}

	public ResponseProduct(String id, String name, String url, String type, int price, long size) {
		// TODO Auto-generated constructor stub
			this.id = id;
		    this.name = name;
		    this.url = url;
		    this.type = type;
		    this.price = price;
		    this.size = size;
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
}
