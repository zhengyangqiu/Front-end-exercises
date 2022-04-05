//name function

function greet(){
    console.log("Hello");
}

// greet();


const sum = function(num1,num2){
    //it is unique to store function to store in a variable
    return num1 + num2;
}

const total=sum(4,5);
// console.log(total);

//arrow function is new function
//arrow denote function

const multiply=(num1,num2)=>{
    return num1*num2;
}
//no need return keyword if just one line
//no need bracket if only one parameter


const product=multiply(4,5);
// console.log(product);


//higher-order functions
//Functions that operate on other functions, either by taking them as arguments or by returning them, are called higher-order functions

//callback means accept other function as parameter



const someOtherFunction = function(param1,param2){
    //do some stuff

}

const myHigherOrderFunction = function (param1,param2,callback){
    callback(param1,param2)
}


myHigherOrderFunction("helle","world",someOtherFunction)
// someOtherFunction("hello","world");



const capitaliseString =string => string.toUpperCase();

//block scope by default

const downcaseString = string => string.toLowerCase();

const manipulateString = (input,callback) => callback(input);

console.log(manipulateString("Hello World",capitaliseString));
console.log(manipulateString("Hello world",downcaseString));

console.log(manipulateString("Hello World",string=>string.split('')));

//high order function -- return another function or accept function as parameter

