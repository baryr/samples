package com.example.customRules;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


public class ExecutionTimeTest {
	
	@Rule
	public TestRule expectedFastTest = new ExpectedFastTestRule(3000);

	@Test
	public void fastTest() {
		assertThat("True is true", "true", is("true"));
	}
	
	@Test
	public void averageTest() {
		try { Thread.sleep(2000); } catch (InterruptedException e) { }
		assertThat("True is true", "true", is("true"));
	}

	@Test
	public void slowTest() {
		try { Thread.sleep(5000); } catch (InterruptedException e) { }
		assertThat("True is true", "true", is("true"));
	}
	
}
