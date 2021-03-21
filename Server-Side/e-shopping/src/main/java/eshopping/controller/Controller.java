package eshopping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eshopping.messages.ResponseCart;
import eshopping.messages.ResponseCartList;
import eshopping.messages.ResponseProduct;
import eshopping.messages.ResponseMessage;
import eshopping.models.Cart;
import eshopping.models.CartList;
import eshopping.models.Product;
import eshopping.services.CartServiceInf;
import eshopping.services.ProductServiceInf;


@RestController
@CrossOrigin("http://localhost:3000")
public class Controller {

	  @Autowired
	  private ProductServiceInf productServiceInf;
	  
	  @Autowired
	  private CartServiceInf cartServiceInf;
	  

	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    	productServiceInf.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseProduct>> getListFiles() {
	    List<ResponseProduct> files = productServiceInf.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();
	      	
	      return new ResponseProduct(  dbFile.getId(), dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getPrice(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());
	    		  
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		  	Product fileDB = productServiceInf.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  } 
	  
	  
	  /////////////////////////////////////////////////////////
	  
	  @GetMapping("/Fullcart")
	  public  ResponseEntity<ResponseCart> getfullCart() {
		 
		 ResponseCart responsecart = cartServiceInf.getCart();
		 
		 return ResponseEntity.status(HttpStatus.OK).body(responsecart);
		    
	  } 
	  
	  
	  
	  @GetMapping("/addtocart")
	  public  ResponseEntity<ResponseCart> addtocart(@RequestParam("x") String cid,@RequestParam("y") int quantity)
	  {
		 
		  boolean msg = cartServiceInf.addtocart(cid, quantity);
		  
		  if(msg) {
			  		ResponseCart responsecart = cartServiceInf.getCart();
		 
			  		return ResponseEntity.status(HttpStatus.OK).body(responsecart);
		  }
		  
		  return null;  
	  }
	  
	  
	  
	  
	  @GetMapping("/updatecart")
	  public  ResponseEntity<ResponseCart> updateCart(@RequestParam("x") String cid,@RequestParam("y") int quantity)
	  {
		 
		  cartServiceInf.updatecart(cid, quantity);
		  
		  ResponseCart responsecart = cartServiceInf.getCart();
		 
		 return ResponseEntity.status(HttpStatus.OK).body(responsecart);
		    
	  } 
	  
	  
	  @GetMapping("/removeitem")
	  public  ResponseEntity<ResponseCart> removeitem(@RequestParam("x") String cid)
	  {
		 
		  cartServiceInf.removeitem(cid);
		  
		  ResponseCart responsecart = cartServiceInf.getCart();
		 
		 return ResponseEntity.status(HttpStatus.OK).body(responsecart);
		    
	  } 
	  
	  
	  @GetMapping("/deleteall")
	  public  ResponseEntity<ResponseCart> deleteall()
	  {
		 
		  cartServiceInf.deleteall();
		  
		  ResponseCart responsecart = cartServiceInf.getCart();
		 
		 return ResponseEntity.status(HttpStatus.OK).body(responsecart);
		    
	  } 
	  
	}
