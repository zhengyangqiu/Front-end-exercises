//give components name start with capital letter
const Hello = () => {

    let string1 ="Hello";
    let string2 = "world";

    let num1=3;
    let num2=5;


    const fruits = ["apple","banana","kiwi","orange"];
    const listedFruit = fruits.map(fruit =>{
        return <li key={fruit}>{fruit}</li>
    })


    return(

        //it is not allow return two element, use div 
        <>
            <h1>{`${string1} ${string2}`}</h1>
            <p>The sum of number is : {num1+num2}</p>
            <p>It is lovely to see you!</p>
            <ul>
                {listedFruit}
                


            </ul>
        </>
     
    )
}


export default Hello;
