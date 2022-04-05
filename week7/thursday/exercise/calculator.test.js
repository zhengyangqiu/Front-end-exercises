const { expect } = require("@jest/globals");
const {
    sum,
    subtract,
    multiply,
    divide,
    modulus,
    even,
    odd,
} = require("./calculator");

describe('sum', () => {

    test('can add two small positive numbers', () => {
        expected = 5;
        actual = sum(2, 3);
        expect(actual).toBe(expected);
    });

    test('can add two large positive numbers', () => {
        expected = 1000000;
        actual = sum(323232,676768);
        expect(actual).toBe(expected);

    });

    test('can add two negative numbers', () => {
        expected = -10;
        actual = sum(-6,-4);
        expect(actual).toBe(expected);


    });

    test.skip('can add zero', () => {

    });

});

describe('subtract', () => {

});

describe('multiply', () => {

});

describe('divide', () => {

});

describe('modulus', () => {

});

describe('even', () => {

});

describe('odd', () => {

});