const {sum} = require("./calculator");

describe("sum function",function(){

    test("sum(2,2) should equal 4",()=>{

        //given, arrange
        //when act
        //then assert
        actual = sum(2,2);
        expected = 4;
        expect(actual).toBe(expected);

    });

    test("sum(0.2,0.2) to be 0.3",()=>{
        actual = sum (0.2,0.1);
        expected = 0.3;
        expect(actual).toBeCloseTo(0.3);


    })


});
