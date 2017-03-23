package com.example.customRules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ExpectedFastTestRule implements TestRule {
	
	private long  maxTimeInMiliSeconds;
	
	public ExpectedFastTestRule(long maxTimeInMiliSeconds) {
		this.maxTimeInMiliSeconds = maxTimeInMiliSeconds;		
	}

	public Statement apply(Statement base, Description description) {
		return new ExpectedFastTestStatement(base);
	}
	
	
	private class ExpectedFastTestStatement extends Statement {
	    private final Statement next;
	    
	    public ExpectedFastTestStatement(Statement base) {
	    	this.next = base;
	    }

		@Override
		public void evaluate() throws Throwable {
			long start = System.nanoTime();
			next.evaluate();
			long stop = System.nanoTime();
			long evaluationTime = (stop - start) / 1000000;
			System.out.println("Executing in evaluationTim: " + evaluationTime);
			if (evaluationTime > maxTimeInMiliSeconds) {
				throw new RuntimeException("To long running test");
			}
		}
	    
	}


}
