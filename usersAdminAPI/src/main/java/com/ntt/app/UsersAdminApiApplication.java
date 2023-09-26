package com.ntt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class UsersAdminApiApplication.
 */
@SpringBootApplication
@ComponentScan({"com.ntt"})
public class UsersAdminApiApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UsersAdminApiApplication.class, args);
	}

}
