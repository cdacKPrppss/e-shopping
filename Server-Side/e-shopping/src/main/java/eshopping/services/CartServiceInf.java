package eshopping.services;

import eshopping.messages.ResponseCart;
import eshopping.models.Cart;

public interface CartServiceInf {


	
	public ResponseCart getCart();
	
	
	public boolean addtocart(String cid, int quantity);
	
	
}
