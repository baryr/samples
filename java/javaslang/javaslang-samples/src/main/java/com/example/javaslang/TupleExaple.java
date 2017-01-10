package com.example.javaslang;

import javaslang.Tuple;
import javaslang.Tuple3;

public class TupleExaple {
	public static void main(String[] args) {
		
		Tuple3<String, Integer, Boolean> tuple1 = Tuple.of("Java", 8, true);
		System.out.println("\ntuple1.arity = " + tuple1.arity());
		System.out.println("tuple1._1 = " + tuple1._1 + " (" + tuple1._1.getClass().getSimpleName() + ")");
		System.out.println("tuple1._2 = " + tuple1._2 + " (" + tuple1._2.getClass().getSimpleName() + ")");
		System.out.println("tuple1._3 = " + tuple1._3 + " (" + tuple1._3.getClass().getSimpleName() + ")");

		Tuple3<String, Integer, Boolean> tuple2 = Tuple.of("Java", 9, false);
		System.out.println("\ntuple2.arity = " + tuple1.arity());
		System.out.println("tuple2._1 = " + tuple2._1 + " (" + tuple2._1.getClass().getSimpleName() + ")");
		System.out.println("tuple2._2 = " + tuple2._2 + " (" + tuple2._2.getClass().getSimpleName() + ")");
		System.out.println("tuple2._3 = " + tuple2._3 + " (" + tuple2._3.getClass().getSimpleName() + ")");
		
		System.out.println("\ntuple1.compareTo(tuple2) = " + tuple1.compareTo(tuple2));
		
		Tuple3<String, String, String> mappedTuple = tuple1.map((s, i, b) -> {
			return Tuple.of(s.toUpperCase(), String.valueOf(i), String.valueOf(b));
		});
		System.out.println("\nmappedTuple.arity = " + mappedTuple.arity());
		System.out.println("mappedTuple._1 = " + mappedTuple._1 + " (" + mappedTuple._1.getClass().getSimpleName() + ")");
		System.out.println("mappedTuple._2 = " + mappedTuple._2 + " (" + mappedTuple._2.getClass().getSimpleName() + ")");
		System.out.println("tuple1._3 = " + mappedTuple._3 + " (" + mappedTuple._3.getClass().getSimpleName() + ")");
		
		System.out.println("\ntuple1.toSeq()");
		tuple1.toSeq()
			.toStream()
			.filter(i -> i instanceof Integer)
			.forEach(System.out::println);
		
		System.out.println("\nTuple transform: " + tuple2.transform((s, i, b) -> {
			return s+i+b;
		}));
		
	}
}
