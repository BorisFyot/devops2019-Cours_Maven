package com.example.apiwebapp;

// Standard springboot framework
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

// springboot packages related to API and Web applications
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// internal package for managing JWT tokens
import com.example.apiwebapp.JWT.*;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class ApiWebappApplication {
		
	// generate a token and then verify it through the main JWT method
	@RequestMapping(value = "/helloworld/api", method = RequestMethod.GET)
	public ResponseEntity<Object> Token() {
		  JWT.main(null);
	      return new ResponseEntity<>("Generated through the API GET request method", HttpStatus.OK);
	}
	
	// number to be displayed on the webpage
	int recorded_number;
	
	// request to modify the number through the API POST method
	@RequestMapping(value = "/helloworld/api/number", method = RequestMethod.POST)
	public ResponseEntity<Object> CreateProduct(int i) {
		  recorded_number =i;
	      return new ResponseEntity<>("This text was sent through the API POST request\n", HttpStatus.CREATED);
	}
	
	// display the webpage with the correct number displayed
	@RequestMapping("/helloworld")
    String home() {
            return "Hello World! \n The number you chose to display is " + recorded_number;
    }	
	
	// run the main app
	public static void main(String[] args) {
		SpringApplication.run(ApiWebappApplication.class, args);
	}
}