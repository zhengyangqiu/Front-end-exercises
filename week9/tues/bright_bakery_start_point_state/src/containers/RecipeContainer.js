import {useState} from 'react';
import Recipe from '../components/Recipe'; 

const RecipeContainer = ({cakes}) => {
    //pass cakes from app.js
    

  

    const cakeList = cakes.map((cake,index) => {
        //add index key
        return (
            //return recipe component
            //first cake is props,second cake is the value of cake
            //recipe is the component that will store data, it is component we want to input data to
            <Recipe cake={cake} 
                    key ={index}/>
            
        )
    })
           

    return(
        // render recipe/ cakelist function name
        <> {cakeList}</>
        
        
    )

}

export default RecipeContainer;