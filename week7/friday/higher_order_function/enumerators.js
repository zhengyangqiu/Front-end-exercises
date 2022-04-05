const numbers = [1,2,3,4,5];

// const doubleNumbers = [];

// for (let i = 0; i < numbers.length; i++) {
//     doubleNumbers.push(numbers[i]*2);
    
// }

const double = function(number){
    return number*2;

}

//map apply callback to each entry in array
const doubleNumbers = numbers.map((number)=>number*2);

console.log(numbers);
console.log(doubleNumbers);

const evenNumber = numbers.filter(function(number){
    return number*2===0;
})