// setTimeout(callback,delay);


// const output=setTimeout(()=>{
//     return "Hello world";
// },2000);

// console.log(output);


// setTimeout(()=>{
//     console.log("Hello");
// },2000);




const resolvedAfter2Seconds = ()=>{
    return new Promise((resolve,reject) => {
        //first argument always resolve
        setTimeout(()=>{
            resolve("hello world")
        },2000);

    });

}


// const output = resolvedAfter2Seconds();
// console.log(output);

// setTimeout(()=>{
//     console.log(output);
// },3000);

//resolve for load database
//reject for database crush


// const asyncFunction = async () => {
//     console.log("calling asyncFunction");
//     const result = await resolvedAfter2Seconds();
//     console.log(result);

// }


// asyncFunction();


const doComplicatedCalculation = (input)=>{
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            if(input<10){
                resolve(input*2);
            }else{
                reject("I can't handle numbers that big!");
            }

        },2000);
    });
}

// const result = doComplicatedCalculation5(5);
// console.log(result);



const asyncCalculator = async(input) => {
    try{
        const result = await doComplicatedCalculation(input);
        console.log(result);
    } catch(error){
        console.error(error);
    }
    
}

asyncCalculator(15);






