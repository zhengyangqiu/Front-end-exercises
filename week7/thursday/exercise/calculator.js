const sum = function (a, b) {
    return a + b;
};

const subtract = function(a,b){
    return a-b;
};

const multiply = (a,b)=> a*b ;

const divide = (a,b) => a /b;

const modulus = (a,b) => a%b;

const even = function(a){
    if(a/2===1){
        return true;
    }else{
        return false;
    }
};

const odd = function(a){

    if(a/2!=1){
        return true;
    }else{
        return false;
    }
};

module.exports = {
    sum,
    subtract,
    multiply,
    divide,
    modulus,
    even,
    odd
};

