package com.example.javaslang;

import javaslang.Function2;
import javaslang.control.Either;
import javaslang.control.Either.Left;
import javaslang.control.Option;

public class ValueExample {
	public static void main(String[] args) {
		Option value1 = Option.of(null);
		Option value2 = Option.of(1);
		
		System.out.println("Value1.isDefined = " + value1.isDefined());
		System.out.println("Value2.isDefined = " + value2.isDefined());
		
		Function2<Integer, Integer, Either<String, Integer>> divide = (a, b) -> {
			try {
				return Either.right(a/b);
			} catch (ArithmeticException e) {
				return Either.left(e.getMessage());
			}
		};
		

	}
}
