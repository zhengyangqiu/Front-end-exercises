const button = document.querySelector("#fetch-button");

const list = document.querySelector("#launch-details");

let launches = [];


const handleLoadDataButtonClick = async()=>{
    //js donot care pass argument without use it
    console.log("button clicked");
    const result = await fetch("https://api.spacexdata.com/v5/launches")
    //return promise, load data from API
    // .then(result => result.json())
    // .then(data=>console.log(data));
    launches = await result.json();
    launches.forEach(element => {
        const heading = document.createElement("dt");
        const content = document.createElement("dd");

        heading.innerText = `Launch number: ${element.flight_number}`;
        content.innerText=element.details;

        list.appendChild(heading);
        list.appendChild(content);

        
    });


}

//it is javascript representation rather than html so it has methods
button.addEventListener("click",handleLoadDataButtonClick);

