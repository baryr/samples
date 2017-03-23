package com.example.theories;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import com.example.theories.customSuppliers.Between;

@RunWith(Theories.class)
public class TheoryTest {
	
	// all public fields of a test class are accepted data points
	@DataPoint
	public static int TWO = 2;
	@DataPoint
	public static int FIVE = 5;
	@DataPoint
	public static int TEN = 10;
	
	@Theory
    public void multiplyIsInverseOfDivideWithPublicDataPoints(int amount, int m) {
        assumeThat(m, not(0));
        assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
    }
	
	@Theory
	public void multiplyIsInverseOfDivideWithInlineDataPoints(
	        @TestedOn(ints = {0, 5, 10, 12}) int amount,
	        @TestedOn(ints = {0, 1, 2, 12}) int m
	) {
	    assumeThat(m, not(0));
	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}
	
	@Theory
	public void multiplyIsInverseOfDivideWithInlineDataPointsByCustomSupplier(
	        @Between(first = -100, last = 100) int amount,
	        @Between(first = -100, last = 100) int m
	) {
	    assumeThat(m, not(0));
	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}
}
