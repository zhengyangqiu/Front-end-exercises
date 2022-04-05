
import {useState} from 'react';
//three part of information



const RecipeForm = ({ handleCakeSubmit}) => {
    //get information and pass to somewhere
    //form in react is called controlled component, status need to track the form

    const [cakeName, setCakesName] = useState("");
    const [ingredients, setIngredients] = useState([]);
    const [rating, setRating] = useState("");

    const handleCakeNameChange = (event)=>{
        //event object has value
        setCakesName(event.target.value);

    }

    const handleIngredientsChange=(event)=>{
        setIngredients(event.target.value);
    }

    const handleFormSubmit = (event)=>{
        event.preventDefault();
        //stop refresh the page
        if(!cakeName || !ingredients || !rating){
            return 
        }
        // TODO 

        handleCakeSubmit({
            cakeName:cakeName,
            ingredients:[ingredients],
            rating:rating
        })

        //set value back to empty
        setCakesName("");
        setIngredients("");
        setRating("");


    }


    const handleRatingChange = (event)=>{
        setRating(event.target.value);
    }
    return(
        <>
            <form onSubmit ={handleFormSubmit}>
                <label htmlFor="cakename">Cake name:</label>
                <input type="text" 
                       id="cakename" 
                       name="cakename"
                       value={cakeName} 
                       onChange={handleCakeNameChange}/>

                <label htmlFor="ingredients">Ingredients:</label>
                <input type="text" 
                        id="ingredients" 
                        name="ingredients" 
                        value={ingredients}
                        onChange={handleIngredientsChange}/>

                <label htmlFor="rating">rating:</label>
                <input type="text" 
                        id="rating" 
                        name="rating"
                        value={rating} 
                        onChange={handleRatingChange}/>

                <input type="submit" value="Post"/>


            </form>
        </>
    )
}   

export default RecipeForm;