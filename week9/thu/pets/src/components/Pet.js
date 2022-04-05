
const Pet = ({pet}) =>{

    return (

        <>
            <h3>{pet.name}</h3>
            <p>{`${pet.age}year old${pet.type}`}</p>

        </>

        
    )

}


export default Pet;
