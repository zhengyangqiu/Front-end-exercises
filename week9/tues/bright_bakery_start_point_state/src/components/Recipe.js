// To be continued (with props)

const Recipe =({cake}) =>{
    //cake is the pros name that pass cake object
    return (
        <div>
            <h3>{cake.cakeName}</h3>
            <p>ingredients:</p>
            <ul>
                {cake.ingredients.map((ingredients,index)=>{
                    return (
                        <li key={index}>{ingredients}</li>
                        //make key unique 
                    )
                }
                    
                )}
            </ul>

            <h6>Rating: {cake.rating}</h6>

        
        </div>




    );
}

export default Recipe;
