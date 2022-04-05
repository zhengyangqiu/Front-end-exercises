import React from "react";
import { useState } from "react";

const Popup = props => {
    // const [isOpen, setIsOpen] = useState(false);

    // const togglePopup = () => {
    //     setIsOpen(!isOpen);
    // }
    return (
        <>
            {/* <button id="helpButton" className="icon" aria-label="Instructions" onClick={togglePopup}>
                
                {isOpen && <Popup
                  content={<>
                  
                    <b className="instructions title">This is Instructions</b>
                  <p >----------------------------------------------------------------------</p>
                  <p className="instruction"> Use our Wordle Helper alongside the Wordle game!</p>

                  <p className="instruction">First, enter the words generated in the large grey boxes from our display into the Wordle game. 
                    Return to our Wordle Helper with the colour pattern that was displayed in Wordle and enter the colour (yellow, green or grey) into the corresponding form entry fields & press SUBMIT.</p>

                  <p className="instruction">The above will generate a new hint for you, which will allow you to repeat the process until you have guessed the right word. Happy guessing!</p>
                 
                  </>}
                  handleClose={togglePopup}
                  
                />}

             
<help-icon>
<svg width="24px" height="24px" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" class="icon">
<path d="M512 64C264.6 64 64 264.6 64 512s200.6 448 448 448 448-200.6 448-448S759.4 64 512 64zm0 820c-205.4 0-372-166.6-372-372s166.6-372 372-372 372 166.6 372 372-166.6 372-372 372z"/>
<path d="M623.6 316.7C593.6 290.4 554 276 512 276s-81.6 14.5-111.6 40.7C369.2 344 352 380.7 352 420v7.6c0 4.4 3.6 8 8 8h48c4.4 0 8-3.6 8-8V420c0-44.1 43.1-80 96-80s96 35.9 96 80c0 31.1-22 59.6-56.1 72.7-21.2 8.1-39.2 22.3-52.1 40.9-13.1 19-19.9 41.8-19.9 64.9V620c0 4.4 3.6 8 8 8h48c4.4 0 8-3.6 8-8v-22.7a48.3 48.3 0 0 1 30.9-44.8c59-22.7 97.1-74.7 97.1-132.5.1-39.3-17.1-76-48.3-103.3zM472 732a40 40 0 1 0 80 0 40 40 0 1 0-80 0z"/>
</svg>

  </help-icon>
 </button> */}
        <div className="popup-box">
            <div className="box">
                <span className="close-icon" onClick={props.handleClose}>x</span>
                {props.content}
            </div>
        </div>
        </>
    );
    
    
};

export default Popup;