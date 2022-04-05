import {useState} from 'react';
//useState could use now, it return array of two element


const Title = () => {
    //create a variable
    const [status,setStatus] = useState("open");
    //set status is the only way to change status value


    //open is the inital value, we could variable in array everything we want
    //status require value of state, setStatus the function to update state
    // status make more dynamic,hook is quite new

    const handleClick = () => {
        if(status==="open"){
            setStatus ("closed");
        }else{
            setStatus("open");
        }
        //type anfn
        console.log("button clicked");
        
    }
    // status === "open"? setStatus("closed") : setStatus("open");
    
    return (

        <>
            <h1>The Bright Bakery</h1>
            <p>est 2022</p>
            {/* add css */}
            <h4 className="red">The bakery is now {status}!</h4>
            <button onClick={handleClick}>Open/Closed</button>
            
            {/* //bracket means run immediate */}
            <br/>
        </>
    )

}

export default Title;