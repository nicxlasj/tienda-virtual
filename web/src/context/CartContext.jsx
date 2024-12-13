import { createContext, useState } from "react";

export const CartContext = createContext();

export function CartContextProvider(props) {
  const [cart, setCart] = useState([]);

  const addToCart = (product) => {
    setCart([...cart, product]);
    console.log(cart);
  };

  const removeToCart = (product) => {
    setCart(cart.filter(p=> p.productId != product.productId));
    console.log(cart);
  }

  return (
    <CartContext.Provider value={{ cart, setCart, addToCart, removeToCart }}>
      {props.children}
    </CartContext.Provider>
  );
}
