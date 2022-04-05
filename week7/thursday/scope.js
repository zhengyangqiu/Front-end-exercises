numbers = [1,2,3,4,5];
// let could number keep the scope


//program know we will use this variable

//const like final in java

let numberToPrint;

for(let number of numbers){
    numberToPrint = number
    //string interpolation
    console.log(`The value of numberToPrint inside the loop is ${numberToPrint}`);
}

console.log(`The value of number outside the loop is ${numberToPrint}`);



