import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import axios from 'axios';

import './App.css';
import {  Products, Cart } from './components';


const App = () => {
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);

  const getProducts = async () => {
    axios.get('http://localhost:7777/files')
      .then((response) => {
        setProducts(response.data)
      
      })
  }

   const getCart = async () => {
    axios.get('http://localhost:7777/Fullcart')
      .then((response) => {
        setCart(response.data)
      
      })
  }

      const handleAddToCart = (productId, quantity) => { 

        axios.get(`http://localhost:7777/addtocart/?x=${productId}&y=${quantity}`)
         .then((response) => {
              setCart(response.data);
              console.log("addtocart is called");
      })
    };
  
  useEffect(() => {
    getProducts();
    getCart();   
  }, []);

  
    return (
      
      <Router>
       <div >
          
          <Switch>
  
            <Route exact path="/">
              <Products products = {products} onAddToCart={handleAddToCart} />
            </Route>
            
            <Route exact path="/Fullcart">
              <Cart
                caart={cart}
                
              />
            </Route>
  
          </Switch>
         
         
      </div>
      </Router>
    
    )
  }
export default App;
