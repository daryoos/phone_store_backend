package com.is.phonestore;

import com.is.phonestore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PhonestoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhonestoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
