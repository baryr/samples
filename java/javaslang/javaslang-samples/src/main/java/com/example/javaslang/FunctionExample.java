package com.example.javaslang;

import javaslang.Function1;
import javaslang.Function2;
import javaslang.control.Option;
import javaslang.control.Option.Some;

public class FunctionExample {
	public static void main(String[] args) {

		Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
		Function2<Integer, Integer, Integer> multiply = (a, b) -> a * b;
		Function1<Integer, Integer> multiply2 = multiply.curried().apply(2);
		
		System.out.println("Function composition and curring:");
		Function2<Integer, Integer, Integer> composition = sum.andThen(multiply2);
		System.out.println("((a+b)*c)(2,3): " + composition.apply(2, 3));
		System.out.println();
				
		Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
		Function2<Integer, Integer, Option<Integer>> safeDivide  = Function2.lift(divide);
		
		System.out.println("Function lifting:");
		Option<Integer> result1 = safeDivide.apply(1, 0);
		System.out.println("1/0 resut is defined: " + result1.isDefined() + " - instanceof Some:  " + (result1 instanceof Some));
		Option<Integer> result2 = safeDivide.apply(4, 2);
		System.out.println("4/2 resut is defined: " + result2.isDefined() + " - instanceof Some:  " + (result2 instanceof Some));
		System.out.println();

	}
}
