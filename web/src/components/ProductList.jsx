import { useContext } from "react";
import { Product } from "./Product";
import { ProductContext } from "../context/ProductContext";

export function ProductList() {
  const products = useContext(ProductContext);
  console.log(products);
  return (
    <>
      <div className="grid grid-cols-3 space-x-3 ml-8 mt-6">
        {products.map((p, i) => (
          <Product product={p} key={i}></Product>
        ))}
      </div>
    </>
  );
}
