// //named function

const greeting = greet ("morning","alice");
console.log(greeting)



function greet(timeOfDay,name){
    console.log(`Good ${timeOfDay},${name}!`);
}


// greet("Morning","Alice","extra stuff");
// greet("Afternoon");


//anonymous functions

//hoist not working for anonymous function
const sum = function(number1,number2){
    return number1 + number2;
}

console.log(sum(5,4));

const multiple = (number1,number2) =>{
    return number1*number2;
}

console.log(multiple(5,5));

















