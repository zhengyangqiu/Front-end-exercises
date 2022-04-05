import {useState, useEffect} from "react";

import PetList from "../components/PetList";
import PetForm from "../components/PetForm";

const PetContainer = () =>{

    const [pets, setPets] = useState([]);
    // initalise empty array

    useEffect(()=>{
        fetch("http://localhost:8080/pets") //return promise
        .then(response=> response.json())//change to json, only need body
        .then(data=>setPets(data))
        .catch(error =>console.error(error));

    },[]);


    const addPetToDatabase=(newPet)=>{
        fetch("http://localhost:8080/pets",{
            method : "POST",
            headers: {
                'Content-Type':'application/json'
            },
            body:JSON.stringify(newPet)
        })
            .then(response=>response.json())
            .then(data=>setPets([...pets,data]));
    }

    return (
        <>
        <PetForm onPetSubmission={addPetToDatabase}/>
        <hr/>

        <PetList allPets = {pets}/>
            
        
        </>
       
    )

}

export default PetContainer;
