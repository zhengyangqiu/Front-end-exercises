// let spacex=[];

// const loadData=()=>{
//     console.log("load data");
//     fetch("https://api.spacexdata.com/v5/launches")// get HTTP data from API
//     .then(result=> result.json()) //get json data
//     .then(data=>spacex=data) //sets spacex array to contain data
//     .then(()=>console.log(spacex))//log spaces array to console-check data has been stored
//     .then(()=>{

//         const list = document.querySelector("#spacex-list");//get list from html by id name

//         const launchNames = spacex.map(launch=>launch.name);
//         launchNames.forEach(launch=>{
//             const listItem = document.createElement("li");
//             listItem.innerText = launch;
//             list.appendChild(listItem);
//         })


//     })

// }

// loadData();

const button = document.querySelector("#fetch-button");

const handleLoadDataButtonClick = () => {
    console.log("button clicked");

}

