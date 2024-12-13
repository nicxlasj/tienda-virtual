import { BrowserRouter, useRoutes } from "react-router-dom";
import { Home } from "./pages/Home";
import { Purchase } from "./pages/Purchase";
import { ProductDetail } from "./pages/ProductDetail";
import { NotFound } from "./pages/NotFound";
import { Cart } from "./pages/Cart";

const AppRoutes = () => {
  const routes = useRoutes([
    {
      path: "/",
      element: <Home />,
    },
    {
      path: "/purchase",
      element: <Purchase />,
    },
    {
      path: "/product-detail",
      element: <ProductDetail />,
    },
    {
      path: "/cart",
      element: <Cart />
    },
    {
      path: "*",
      element: <NotFound />,
    },
  ]);
  return routes;
};

function App() {
  return (
    <BrowserRouter>
      <AppRoutes />
    </BrowserRouter>
  );
}

export default App;
