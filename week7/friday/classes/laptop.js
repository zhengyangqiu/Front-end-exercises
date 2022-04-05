const Laptop = function(manufacture, model, operatingSystem){
    this.manufacture = manufacture;
    this.model = model ;
    this.operatingSystem= operatingSystem;

}

Laptop.prototype.install = function (program){
    console.log(`${this.model} installed ${program}`);
}

module.exports = Laptop;
