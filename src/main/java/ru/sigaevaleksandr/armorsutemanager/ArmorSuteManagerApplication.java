package ru.sigaevaleksandr.armorsutemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.sigaevaleksandr")
public class ArmorSuteManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmorSuteManagerApplication.class, args);
	}

}

