/**
 * This is annotation example
 */
package com.adam.app.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AnnotationTest {

	public static void main(String[] args) {
		
		System.out.println("Demo start...");
		
		Class<?> cls = DemoExample.class;
		
		// Process information
		if (cls.isAnnotationPresent(DemoInfo.class)) {
			
			Annotation annotation = cls.getAnnotation(DemoInfo.class);
			DemoInfo demoInfo = (DemoInfo)annotation;
			
			System.out.printf("%nPriority = %s", demoInfo.priority());
			System.out.printf("%nCreatedBy = %s", demoInfo.createdBy());
			System.out.printf("%nTags: ");
			
			int tagLength = demoInfo.tags().length;
			
			for (String tag : demoInfo.tags()) {
				
				if (tagLength > 1) {
					System.out.print(tag + ",");
				} else {
					System.out.print(tag);
				}
				
			}
		
			System.out.printf("%nlastModified: %s%n%n", demoInfo.lastModified());
		}
		
		// Process method
		for (Method method : cls.getDeclaredMethods()) {
			
			// the method is annotated with method
			if (method.isAnnotationPresent(Demo.class)) {
				Annotation annotation = method.getAnnotation(Demo.class);
				Demo demo = (Demo) annotation;
				
				// check enable
				if (demo.enable()) {
					try {
						method.invoke(cls.newInstance());
						System.out.println("Test: " + method.getName() + " is pass");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Test: " + method.getName() + " is false");
				}
				
			}
			
		}
		
		
	}

}
