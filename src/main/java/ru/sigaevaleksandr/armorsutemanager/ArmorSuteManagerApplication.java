package ru.sigaevaleksandr.armorsutemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.Optional;

@SpringBootApplication
public class ArmorSuteManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmorSuteManagerApplication.class, args);
	}

}

