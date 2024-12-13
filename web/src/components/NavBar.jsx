import { FaShoppingCart } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

export function NavBar() {
  const navigate= useNavigate();
  return (
    <div className="h-20 bg-neutral-500 pt-7 flex justify-between">
      <h1 className="text-4xl text-white font-extrabold ml-4">
        <span className="font-light">Tech </span>Store
      </h1>
      <div className="mx-8 pt-1.5 text-white flex space-x-6">
        <input type="text" className="w-56 h-8 rounded-md p-2 text-black focus:outline-none" placeholder="Search"></input>
        <img src="https://avatars.githubusercontent.com/u/69995007?v=4" className="rounded-full h-8 w-8 hover:cursor-pointer"></img>
        <FaShoppingCart className="h-6 w-6 mt-1 hover:cursor-pointer" onClick={()=> {
          navigate("/cart");
        }}/>
      </div>
    </div>
  );
}
