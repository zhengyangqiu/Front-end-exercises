import { useState, useEffect } from "react";
import Word from "../Components/Word";
import SubmitForm from "../Components/SubmitForm";
import Grid from "../Components/Grid";





//setting our state
const WordleContainer = () => {

    const [words, setWords] = useState([]);


    useEffect(() => {
        
        fetch("http://localhost:8080/helper/start")
            .then(response => response.json())  // Strip data we want from response using json function
            .then(data => setWords(data[0]))    // Set words array to be the first index of our data
    }, [])

    
    // fetch("http://localhost:8080/helper/start/{words}");
    //update variable in the path
    const filterWordList = async (newWordObject) => {
            // console.log(words.word);
            // console.log(newWordObject);

            // Need to use an await below because we don't want the function to execute until the fetch request is satisfied - account for even the smallest fraction of a delay in response, since working with a large database
            await fetch(`http://localhost:8080/helper/start/${words.word}`, {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newWordObject)
        })
            .then(response => response.json())  // Strip data we want from our response
            .then(data => setWords(data[0])) // Update state for words array with first index filtered word that is new suggestion
            // console.log(newWords);
            // setWords(newWords[0]); - alternative use, which requires "newWords" variable to be created - have "const newWords = " before the await fetch
            // console.log("these are your new word");
            // console.log(words);
        }
    

    return (
        <>
            {/* <Word word={words} /> */}
             <Grid word={words} />
                
                
            <center> <SubmitForm  onWordSubmission={filterWordList} word={words}/> </center>
            
            


            
        </>
    )

}




export default WordleContainer;
