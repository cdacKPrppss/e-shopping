package eshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eshopping.messages.ResponseCart;
import eshopping.messages.ResponseCartList;
import eshopping.models.Cart;
import eshopping.models.CartList;
import eshopping.models.Product;
import eshopping.dao.CartRepository;
import eshopping.dao.ProductRepository;

@Service
public class CartServiceImp implements CartServiceInf{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository filedbRepository;
	
//	public List<Cart> getCart() {
//		return cartRepository.findAll();
//	}
	
	
	
	public ResponseCart getCart() {
		
		 int totalitems=0;
		 int totalprice=0;
		
		 List<Cart> cl = cartRepository.findAll();
		  List<CartList> lt = new ArrayList<>(); 
		  
		  for(Cart c:cl) {
			  String cid = c.getCid();
			  Product p = filedbRepository.findById(cid).get();
			  CartList item = new CartList(cid, p.getName(), p.getType(), p.getPrice(), p.getData(), c.getQuantity());
			  
			  totalitems = totalitems + c.getQuantity();
			  totalprice = totalprice + p.getPrice()*c.getQuantity();
		
			  lt.add(item);
			  
		  }
		  
		 
		 List<ResponseCartList> itms = new ArrayList<>(); 
		  
		 for(CartList item : lt) {
			
			        String fileDownloadUri = ServletUriComponentsBuilder
			            .fromCurrentContextPath()
			            .path("/files/")
			            .path(item.getId())
			            .toUriString();
			      	
			      ResponseCartList rl = new ResponseCartList(  item.getId(), item.getName(),
			          fileDownloadUri,
			          item.getType(),
			          item.getPrice(),
			          item.getData().length, 
			          item.getQuantity());
			 
			      itms.add(rl);
		 }
		
		 ResponseCart responsecart = new ResponseCart(totalitems, totalprice, itms);	
		 return responsecart;
		
	}

	
	
	
	public boolean addtocart(String cid, int quantity)
	{
		if(cartRepository.existsById(cid))
		{
			Cart item = cartRepository.findById(cid).get();
			int qty = item.getQuantity();
			qty = qty + 1;
			item.setQuantity(qty);
			cartRepository.save(item);
			
			return true;
		}
		else
		{
			Cart item = new Cart(cid, quantity);
			cartRepository.save(item);
			
			return true;
		}
		
		
	}
	
	
		
}
