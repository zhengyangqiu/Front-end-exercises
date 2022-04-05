const DisplayCakes = () =>{

    const cakes = [
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
    ]

    const listCake = cakes.map(function(cake){
        // return <li>`cakeName:${cake.cakeName} ingredients: ${cake.ingredients} rating: ${cake.rating} `</li>;
        return <li>cakeName:{cake.cakeName} ingredients: {cake.ingredients.map(ingredient=>
            {return <li key={ingredient}>{ingredient}</li>})} 
            rating: {cake.rating} </li>;
            
    })


    return(
        <>
        <ul>
             
            {listCake}
            


        </ul>

        


        </>


    )


}

export default DisplayCakes;


