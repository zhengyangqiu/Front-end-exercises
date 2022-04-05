import { useState } from "react";

const PetForm = ({onPetSubmission})=>{

    const [name, setName]= useState("");
    const [age,setAge]=useState(0);
    const [type,setType]= useState("");
    const [breed, setBreed] = useState("");

    const handleNameChange = (event)=>{
        setName(event.target.value);

    }

    const handleAgeChange = (event) => {
        setAge(event.target.value);

    }

    const handleTypeChange = (event) => {
        setType(event.target.value);

    }

    const handleBreedChange = (event) => {
        setBreed(event.target.value);

    }

    const handleFormSubmit = (event)=>{
        event.preventDefault();

        if(!name||!age||!type||!breed){

            alert("missing information");
            return; 
        }

        const newPetObject = {
            name:name,
            age:age,
            type:type,
            breed:breed

        }

        onPetSubmission(newPetObject);
        
        setName("");
        setAge(0);
        setType("");
        setBreed("");
    }




    return (

       <form onSubmit={handleFormSubmit}>
           <label htmlFor="name">Name:</label>
           <input type="text" id="name" value={name} onChange={handleNameChange} />
            <label htmlFor="age">age:</label>
            <input type="number" id="age" value={age} onChange={handleAgeChange} />

            <label htmlFor="type">Type:</label>
            <input type="text" id="type" value={type} onChange={handleTypeChange} />

            <label htmlFor="breed">Breed:</label>
            <input type="text" id="Breed" value={breed} onChange={handleBreedChange} />

            <input type="submit" value="Add new Pet" />

       </form>
    )
}

export default PetForm;