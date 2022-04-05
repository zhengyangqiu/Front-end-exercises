import Pet from "./Pet"


const PetList= ({allPets}) =>{
    //allpets is props
    const petNodes = allPets.map(pet=>{
        return <Pet pet={pet} key={pet.id}/>
        //index could also be pet.id because pet has unique id
    })

    return (

        <>
        {petNodes}
        
        
        </>
    )

}

export default PetList;

