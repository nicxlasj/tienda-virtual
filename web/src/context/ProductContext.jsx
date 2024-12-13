import { createContext, useEffect, useState } from "react";

export const ProductContext = createContext();

export function ProductContextProvider(props) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8980/tienda-virtual/api/products")
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setProducts(data);
        
      })
      
  }, []);

  return (
    <ProductContext.Provider value={products}>
      {props.children}
    </ProductContext.Provider>
  );
}
