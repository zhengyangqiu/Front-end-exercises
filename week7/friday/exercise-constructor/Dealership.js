const Dealership = function(name,maximum,cars=[]){
    this.name=name,
    this.maximum=maximum
    this.cars=cars

}

Dealership.prototype.printCarManufactures = function(){
    for(const car of this.cars){
        console.log(car.manufacturer)
    }
}

Dealership.prototype.addCar= function(car){
    this.cars.push(car);
}

Dealership.prototype.findAllCar = function(manufacturer){
    manufacturerCar=[];
    for(const car of this.cars){
        if(car.manufacturer===manufacturer){
            manufacturerCar.push(car)

        }else{
            console.log("cannot find any car");
        }
    }

}

module.exports = Dealership
