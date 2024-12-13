export function totalPrice(arr) {
  let price = 0;
  arr.map((p) => {
    price = price + p.price;
  });
  return price;
}
