package com.learning.building;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerBuildingControl {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("META-INF\\spring\\app-context.xml");
	}
}
