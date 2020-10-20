package com.techprimers.testing;

public class FizzBuzz {

    public String play(int number) {

        if (number == 0) throw new IllegalArgumentException("Number must not be 0");
        if (number % 2 == 0) return "Fizz";
        
                 return "Buzz";
    }
}
