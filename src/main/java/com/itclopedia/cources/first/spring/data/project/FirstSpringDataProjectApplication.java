package com.itclopedia.cources.first.spring.data.project;

import com.itclopedia.cources.first.spring.data.project.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class FirstSpringDataProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstSpringDataProjectApplication.class, args);

		MainController mainController = context.getBean(MainController.class);

		mainController.getAllStreets(false)
				.forEach(System.out::println);

		System.out.println(mainController.findStreetByName("Dubko"));

		System.out.println(mainController.findByNumber(12));
		System.out.println(mainController.findByNumberNativeSQL(12));
	}

}
