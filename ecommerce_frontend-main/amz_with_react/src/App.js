import './App.css';
import './styles/shared/general.css';
import Axios from "axios";

import { Amazon } from './Amazon';
import { BrowserRouter as Router,Routes, Route} from 'react-router-dom';
import { Checkout } from './Checkout';
import { Orders } from './Orders';
import Track from './Track';
import { useState,useEffect,createContext } from'react';
import { useCart} from './data/Cart';
import { useOrderCart } from './data/Orders';

import { useUsers } from './data/Users';
import { useDispatch, useSelector } from 'react-redux';

import { useQuery } from '@tanstack/react-query';
import { useQueryClient } from '@tanstack/react-query'; // Import useQueryClient
import { useProducts } from './data/products';
import { UseDispatch } from 'react-redux';
import { setUser } from './store';
export const CartContext = createContext();
export const UserContext = createContext();
export const ProductsContext = createContext();

function App() {

  const [products, setProducts] = useState([]);
  const [isLoading, setLoading] = useState(true);
const dispatch = useDispatch();
  useEffect(() => {
    Axios.get("/api2/product")
      .then((res) => {
        console.log(res.data);
        setProducts(res.data);
        setLoading(false);
      })
      .catch((error)=>{
        console.error("error...... ", error);
        setLoading(false);
      });
  }, []);

  //console.log(products);
  const [useriId,setUserId] = useState(null);
  const { users, initializeUsers, addToUsers, saveToUsers, validateUser} = useUsers([],setUserId);
  const userId = useSelector(state => state.user.userId) || (JSON.parse(localStorage.getItem('user'))?.id);

  useEffect(()=>{
    console.log('refresh?');
    initializeUsers();
    setLoggedIn(!!userId)
    if(localStorage.getItem('user')){
    setUserId(localStorage.getItem("user").id);
    dispatch(setUser(userId));
  }
    console.log(isLoggedIn);
  },[]);

  const [isLoggedIn, setLoggedIn]=useState(false);
 

  useEffect(()=>{
  
    console.log('UserId:',userId);
    setLoggedIn(!!userId);
  },[userId])
  console.log(userId, isLoggedIn);

  const { cart,cartQuantity, initializeCart, initializeCartQuantity, addToCart, removeFromCart, saveAddCartQuantity, updateDeliveryOption} = useCart([],userId);
  const {orderCart, orderQuantity, initializeOrderCart, initializeOrderQuantity, addToOrderCart, saveToOrderCart, saveAddOrderQuantity} =useOrderCart([], cart, initializeCart, userId);

  useEffect(()=>{
    if(userId){
      initializeCart();
      initializeCartQuantity();
      initializeOrderCart();
      initializeOrderQuantity();
    }
  },[userId]);

  useEffect(()=>{
    if(userId)
      saveAddCartQuantity();
  },[cart]);

  useEffect(()=>{
    if(userId)
      initializeCart();
  },[orderCart]);

  // console.log('error:',error);
  if(isLoading){
    return (<div>loading........</div>);
  }
  
  return (
    <ProductsContext.Provider value={{products}}>
    <UserContext.Provider value={{ users, addToUsers, saveToUsers, validateUser, isLoggedIn}}>
        {isLoggedIn ? (
          <CartContext.Provider value={{ cart,cartQuantity, initializeCart, initializeCartQuantity, addToCart, removeFromCart, saveAddCartQuantity, updateDeliveryOption, orderCart, orderQuantity, initializeOrderCart, initializeOrderQuantity, addToOrderCart, saveToOrderCart, saveAddOrderQuantity }}>
            <div className="App">
              <Router>
                <Routes>
                  <Route path="/" element={<Amazon/>} />
                  <Route path='/checkout' element={<Checkout/>} />
                  <Route path="/orders" element= {<Orders/>} />
                  <Route path="/Track" element= {<Track/>} />
                </Routes>
              </Router>
            </div>
          </CartContext.Provider>
        ) : (
          <div className="App">
            <Router>
              <Routes>
                <Route path="/" element={<Amazon/>} />
              </Routes>
            </Router>
          </div>
        )}
    </UserContext.Provider>
    </ProductsContext.Provider>
  );
}

export default App;

 