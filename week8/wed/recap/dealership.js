const Dealership= function(name,capacity,cars=[]){
    this.name = name;
    this.capacity=capacity;
    //set value car list []
    this.cars = cars;

}


Dealership.prototype.printCarManufacturers = function(){

    // need let to keep in the scope, without let will be global scope
    for (let car of this.cars){
        console.log(car.manufacturer)
    }
}

Dealership.prototype.addCar = function(){
    this.cars.push(car);
}



module.exports = Dealership;



