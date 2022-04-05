import {useState,useEffect} from "react";
import ColourPicker from "../components/ColourPicker";
import ColourDisplay from "../components/ColourDisplay";

const ColourPickerContainer = () =>{

    const [red,setRed] = useState(50);
    const [green,setGreen]=useState(50);
    const [blue,setBlue]=useState(50);
    const [rbg,setRgb] = useState(null);
    //50% filled

    useEffect(()=>{
        console.log("userEffect called");
        let red255=Math.ceil(red*2.55);
        let green255 = Math.ceil(green*2.55);
        let blue255 = Math.ceil(blue * 2.55);
        
        setRgb(`rgb(${red255},${green255},${blue255})`);
        

    },[red,green,blue]);





    const updateRed = (event) => {
        setRed(event.target.value);
    }

    const updateGreen = (event)=>{
        setGreen(event.target.value);
    }

    const updateBlue = (event) => {
        setBlue(event.target.value);
    }




    return (
        <>
            <h1>ColourPicker</h1>
            <ColourPicker
                  red={red}
                  green={green}
                  blue={blue}
                  onRedChange={updateRed}
                  onGreenChange={updateGreen}
                  onBlueChange={updateBlue}

            
            />
            <ColourDisplay rgb={rgb} />
        
        
        </>
        
    )
}

export default ColourPickerContainer;
