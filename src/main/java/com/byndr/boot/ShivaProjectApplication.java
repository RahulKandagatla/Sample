/*  @(#)ShivaProjectApplication.java
 * 
 * spring boot starter class and the project starts execution from this class
*/

package com.byndr.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * spring boot starter class and the project starts execution from this class
 * @author RAHUL
 * @version 1.0.0
 * @category spring boot starter
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class ShivaProjectApplication {
	/**
	 * @param args
	 * @return nothing
	 * @category main 
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(ShivaProjectApplication.class, args);
	}

}
