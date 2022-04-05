const sum = function(num1 , num2){
    return num1 + num2;
}

const multiply = function(num1,num2){
    return num1 * num2;
}


const subtract = function(num1, num2){
    return num1 - num2;
}


const divide = function(num1,num2,callback){
    return callback(num1,num2);
}

const divide = function(num1,num2){
    return num1/num2;
}

const manipulateNumber = function(num1,num2,callback){
   return callback(num1,num2);

}



const total = manipulateNumber(5,10,sum);
const product = manipulateNumber(5,10,multiply);
const difference = manipulateNumber(5,10,subtract);
const quotient = manipulateNumber(5,10,divide);

const modulus = manipulateNumber(5,10, (num1,num2)=> num1 % num2);


console.log(total);
console.log(product);
console.log(difference);
console.log(quotient);
console.log(modulus);



