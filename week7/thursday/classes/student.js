
// constructor function

//property for class

const Student = function(name){
    this.name = name;
    this.laptop = null;

}

//methods for prototype

Student.prototype.greet = function(){
    console.log(`Hello, my name is ${this.name}`);
}

Student.prototype.buyLaptop = function(laptop){
    this.laptop = laptop;
    
}


Student.prototype.addProgramToLaptop = function(program){
    this.laptop.install(program);
}    

module.exports = Student;












