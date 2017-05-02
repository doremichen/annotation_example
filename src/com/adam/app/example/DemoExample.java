package com.adam.app.example;

import com.adam.app.example.DemoInfo.PriorityType;

@DemoInfo (
		priority = PriorityType.MEDIUM,
		createdBy = "jenson",
		tags = {"test", "release"}
		)
public class DemoExample {

	@Demo
	void testA() {
		
		System.out.println("testA is always passed.");
	}
	
	@Demo(enable = false)
	void testB() {
		
		System.out.println("testB is always passed.");
	}
	
	@Demo(enable = true)
	void testC() {
		
		System.out.println("testC is always passed.");
	}
}

