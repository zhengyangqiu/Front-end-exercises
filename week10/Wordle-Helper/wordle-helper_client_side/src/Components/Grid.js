import { useEffect, useState } from "react";

//inital status is null

const Grid = ({word}) => {
  



const [oneWord,setOneWord] = useState('tares');

// const [colour, setColour] = useState("grey");



useEffect(()=>{
  if (word.word !=null) {
    setOneWord(word.word);
    
  }
},[word]
//run word change status
) 



const items = document.getElementsByClassName("item")
 const itemColour = ["grey", "yellow", "green"]

for (let i = 0; i < items.length; i++){
  items[i].addEventListener("click", ()  => {

  let item = items[i]

    const currentColour = item.getAttribute("colour")

 
    const colourIndex = itemColour.indexOf(currentColour);
 
    const nextColour = itemColour[(colourIndex + 1)%3];
 
    item.setAttribute("colour", nextColour)
 
  })
}



    return(

      // { word.word[0] }
     
      <>
       <div id="grid">

        <div className="item" id="square0" colour="grey">{oneWord[0]}</div>
        <div className="item" id="square1" colour="grey">{oneWord[1]}</div>
        <div className="item" id="square2" colour="grey">{oneWord[2]}</div>
        <div className="item" id="square3" colour="grey">{oneWord[3]}</div>
        <div className="item" id="square4" colour="grey">{oneWord[4]}</div>
        </div>
      
      </>
       

    )



}

export default Grid;