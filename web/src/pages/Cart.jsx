import { FaRegCircleXmark } from "react-icons/fa6";
import { GoPlus } from "react-icons/go";
import { FiMinus } from "react-icons/fi";
import { useContext, useEffect, useState } from "react";
import { CartContext } from "../context/CartContext";
import { totalPrice } from "../utils/totalPrice";
import { toast, Toaster } from "react-hot-toast";

export function Cart() {
  const context = useContext(CartContext);
  const cart = context.cart;
  const [purchase, setPurchase] = useState({});
  useEffect(() => {
    console.log(cart);
    setPurchase({
      userId: 1,
      clientId: "1122334455",
      paymentMethodId: 3,
      paymentMethod: {
        name: "tarjeta de credito",
        abbreviation: "tc",
      },
      items: cart.map((p) => {
        return { product: { ...p }, quantity: 1, total: p.price };
      }),
    });
    console.log(purchase);
  }, [cart]);

  // const add = (product) => {
  //   setPurchase((prevPurchase) => {
  //     let items = [...prevPurchase.items];
  //     let item = items.find((p) => p.product.productId === product.productId);
  //     if (item) {
  //       item.quantity++;
  //       item.total = item.product.price * item.quantity;
  //     } else {
  //       items.push({ product: { ...product }, quantity: 1, total: 0 });
  //     }
  //     return { ...prevPurchase, items };
  //   });
  //   console.log(purchase);
  // };

  const buy = () => {
    fetch("http://localhost:8980/tienda-virtual/api/purchases", {
      method: "POST",
      body: JSON.stringify(purchase),
      headers: { "Content-type": "application/json; charset=UTF-8" },
    })
      .then(() => toast.success("Purchase made successfully!"))
      .catch((error) => console.error(error));
  };

  return (
    <div className="w-screen h-screen flex justify-between">
      <div className="px-32 py-16 w-full">
        <div className="flex justify-between">
          <h1 className="font-extrabold text-3xl">Shopping cart</h1>
          <h1 className="text-lg mt-2.5">{cart.length} items</h1>
        </div>
        <div className="mt-12">
          {cart.map((p) => (
            <>
              <hr className="mt-2"></hr>
              <div className="mt-4 flex space-x-24">
                <img
                  src={p.image}
                  className="h-32 w-20 rounded-md object-cover"
                ></img>
                <div className="my-auto">
                  <p className="font-semibold text-sm text-slate-800">
                    {p.category.name}
                  </p>
                  <p className="font-semibold">{p.name}</p>
                </div>
                {/* <div className="flex space-x-2 my-auto cursor-pointer">
                  <GoPlus className="h-6 w-6" onClick={() => add(p)} />
                  <input
                    type="text"
                    className="w-8 h-6 border border-black text-center"
                    disabled
                    value={1}
                  />
                  <FiMinus className="h-6 w-6" />
                </div> */}
                <div className="my-auto">
                  <p>${p.price}</p>
                </div>
                <div className="my-auto mr-8">
                  <FaRegCircleXmark
                    className="h-6 w-6 text-slate-500 cursor-pointer"
                    onClick={() => {
                      context.removeToCart(p);
                    }}
                  />
                </div>
              </div>
            </>
          ))}
        </div>
      </div>
      <div className="h-full w-3/6 bg-neutral-300 px-8">
        <h1 className="text-2xl font-semibold text-zinc-700 mt-16">Summary</h1>
        <div className="w-full flex justify-between mr-6 mt-10">
          <h1 className="font-semibold text-zinc-700">TOTAL</h1>
          <h1 className="font-semibold text-zinc-700">${totalPrice(cart)}</h1>
        </div>
        <h1 className="mt-5 font-semibold text-zinc-700">PAYMENT METHOD</h1>
        <select className="mt-5 w-80 px-4 h-10">
          <option value={1}>Tarjeta debito</option>
          <option value={2}>Efectivo</option>
          <option value={3}>Tarjeta credito</option>
        </select>
        <button
          className="w-96 bg-black text-white font-semibold rounded-md h-10 mt-10"
          onClick={() => {
            buy();
          }}
        >
          Checkout
        </button>
        <Toaster />
      </div>
    </div>
  );
}
