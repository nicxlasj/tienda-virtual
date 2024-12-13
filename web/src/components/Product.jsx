import PropTypes from "prop-types";
import { useContext, useState } from "react";
import { CartContext } from "../context/CartContext";

export function Product({ product }) {
  const cartContext = useContext(CartContext);
  const [isDisable, setIsDisable] = useState(false);
  return (
    <div className="mt-5 h-80 w-96 rounded-md shadow-2xl ">
      <img
        src={product.image}
        className="h-1/2 w-full rounded-sm object-cover hover:cursor-pointer"
      />
      <div className="mx-2 mt-3 space-y-4">
        <p className="text-xl font-extrabold">{product.name}</p>
        <p className="text-base font-medium text-slate-800">
          {product.category.name}
        </p>
      </div>
      <div className="mx-2 mt-5 flex justify-between">
        <p className="text-2xl font-extrabold">${product.price}</p>
        <button
          className={isDisable ? "w-28 rounded-full bg-emerald-600 font-semibold text-white" : "w-28 rounded-full bg-blue-600 font-semibold text-white transition delay-150 duration-300 ease-in-out hover:-translate-y-1 hover:scale-110 hover:bg-blue-700 hover:shadow-lg"}
          onClick={() => {
            cartContext.addToCart(product);
            setIsDisable(true);
          }}
          disabled={isDisable}
        >
          {isDisable ? "In cart" : "Add to cart"}
        </button>
      </div>
    </div>
  );
}

Product.propTypes = {
  product: PropTypes.object.isRequired,
};
