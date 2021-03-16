package eshopping.models;

import java.util.Arrays;

import javax.persistence.Lob;


public class CartList {
	
	  private String id;

	  private String name;

	  private String type;
	  
	  private int price;

	  @Lob
	  private byte[] data;
	  
	  private int quantity;

	public CartList() {
		
	}

	public CartList(String id, String name, String type, int price, byte[] data, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.data = data;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartList [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", data="
				+ Arrays.toString(data) + ", quantity=" + quantity + "]";
	}
	  
	  


}
