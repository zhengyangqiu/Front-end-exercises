const names=["Darshil","Rogyn","Adib","Anna","Colin"];
console.log(names);

// const darshil = names[0];
// console.log(darshil);
//destructing syntax
//separate operator 

const [name1, ,name2 ,...remainingNames]=names;

console.log(name1);
console.log(name2);

//In JavaScript, only objects and arrays are mutable

console.log(remainingNames);


//object destructing

const person = {
    name:"Erin",
    age:9
}

const firstName = person.name;
const personAge = person["age"];


//the key should be the same 
const{name,age} = person;

//name is keyword, so it is cross out
console.log(name);
console.log(age);



