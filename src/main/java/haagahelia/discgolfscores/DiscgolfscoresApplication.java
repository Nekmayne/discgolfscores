package haagahelia.discgolfscores;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.discgolfscores.domain.CourseRepository;
import haagahelia.discgolfscores.domain.User;
import haagahelia.discgolfscores.domain.UserRepository;

@SpringBootApplication
public class DiscgolfscoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscgolfscoresApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CourseRepository repository, UserRepository uRepository) {
		return (args) -> {

			User user1 = new User("user", "$2a$10$a1uN4cRSwIeIDj1l8Z1ZlOADz4CO4EuIa1rLT6zdgpbGyea4D9oa2", "email", "USER");
			User user2 = new User("admin", "$2a$10$uWfXdetlWLrJFPTH4AHonOO2trGDDZfm7OVUnVyxgGs1C/YD56wHS", "email1", "ADMIN");

			uRepository.save(user1);
			uRepository.save(user2);

		};
	}
}
