package com.adam.app.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DemoInfo {
	
	public enum PriorityType {
		LOW, MEDIUM, HIGH
	}
	
	// priority config
	PriorityType priority() default PriorityType.LOW;
	
	// tag config
	String[] tags() default "";
	
	// created config
	String createdBy() default "Adam";
	
	// lasted modify config
	String lastModified() default "2017/05/02";
}

/*
 * ===========================================================================
 *
 * Revision history
 *  
 * ===========================================================================
 */
