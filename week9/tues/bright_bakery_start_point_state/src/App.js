import './App.css';
import {useState} from 'react';
import Title from './components/Title';
import Search from './components/Search';
import NavBar from './components/NavBar';
import RecipeForm from './components/RecipeForm';
import RecipeContainer from './containers/RecipeContainer';

function App() {
  //usestate take initial value of cake

  const [cakes, setCakes] = useState([
    {
      cakeName: "Lemon Drizzle",
      ingredients: ["eggs", "butter", "lemon  zest", "sugar", "self-raising flour"],
      rating: 5
    },
    {
      cakeName: "Tea Loaf",
      ingredients: ["eggs", "oil", "dried fruit", "sugar", "self-raising flour", "strong tea"],
      rating: 3
    },
    {
      cakeName: "Brownie",
      ingredients: ["chocolate", "eggs", "flour", "butter", "walnuts"],
      rating: 4
    },
    {
      cakeName: "Carrot Cake",
      ingredients: ["carrots", "walnuts", "oil", "cream cheese", "flour", "sugar"],
      rating: 5
    }
  ])

  const addCake = (submittedCake) =>{
    //create new array 
    const updateCakes = [...cakes, submittedCake];
    //... cakes means all the cakes
    setCakes(updateCakes);


  }

  return (
    <>
    <Title/>
    <Search/>
    <NavBar/>
    <RecipeForm handleCakeSubmit = {(cake)=>addCake(cake)}/>
    {/* cake represent submmitcake  */}
    {/* function name need change for props */}
    <RecipeContainer cakes={cakes}/>
    {/* //pass cakes as props value from state */}
    
    
    </>
  );




  
}

export default App;
