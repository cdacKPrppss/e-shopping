import React, { useState, useEffect } from 'react';

import axios from 'axios';

import './App.css';
import {  Products } from './components';


const App = () => {
  const [products, setProducts] = useState([]);


  const getProducts = async () => {
    axios.get('http://localhost:7777/files')
      .then((response) => {
        setProducts(response.data)
      
      })
  }

  
  
  useEffect(() => {
    getProducts();
   
  }, []);

  
    return (
      
        <div>
           
              <Products products = {products}  />
          
      
      </div>
    
    )
  }
export default App;
