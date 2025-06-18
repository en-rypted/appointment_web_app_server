package com.appointment.server;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		try {
			Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
			System.setProperty("MONGO_DB_URI", dotenv.get("MONGO_DB_URI"));
		} catch (Exception e) {
			System.out.println(".env not found — skipping (running in CI?)");
		}

		SpringApplication.run(ServerApplication.class, args);
	}

}
