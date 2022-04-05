const Car = require("./car");

const Dealership = require("./Dealership");

const car1 = new Car("skoda",10000,"petrol");
const car2 = new Car("mini",5000,"diesel");


const cars=[car1, car2];

const Dealership1= new Dealership("filled dealership",10,cars);
const Dealership2 = new Dealership("empty dealership",10);

Dealership1.printCarManufactures();
Dealership2.addCar();

