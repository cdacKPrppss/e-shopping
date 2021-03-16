package eshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eshopping.models.Cart;

@Repository
public interface CartRepository extends JpaRepository <Cart, String>{

}