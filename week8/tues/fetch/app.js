let countries = [];

const loadData =()=>{
    console.log("loading data");
    fetch("https://restcountries.com/v3.1/all")
    .then(result => result.json())
    .then(data => countries = data)
    .then(()=>{
        const list = document.querySelector("#country-list");
        // const countryNames =countries.map(country => country.name.official);
        // countryNames.forEach((name)=>{
        //     const listItem = document.createElement("li");
        //     listItem.innerText=name;
        //     list.appendChild(listItem);

        // });
    countries.forEach(country => {
        const listItem = document.createElement("li");
        listItem.innerText =country.name.official;
        list.appendChild(listItem);
    })


    })
    // .catch(console.error("some errors"))
    // .then(()=>console.log("countries after fetch:",countries))

}

loadData();


// const renderData = async ()=>{
//     await loadData();
//     const list = document.querySelector("#country-list");
//     const countryNames = countries.map(country => {
//         return country.name.official});
//     console.log(countryNames);
// }

// renderData();



// console.log(countries);
