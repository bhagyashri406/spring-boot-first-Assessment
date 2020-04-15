package com.assignment.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstApplication {
	
	 private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext =	SpringApplication.run(FirstApplication.class, args);
		displayAllBeans();
	}

	
	 public static void displayAllBeans() {
	        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
	        for(String beanName : allBeanNames) {
	            System.out.println("BEAN  :  "  + beanName);
	        }
	    }
}
