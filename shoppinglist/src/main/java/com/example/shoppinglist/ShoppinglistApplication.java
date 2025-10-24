package com.example.shoppinglist;

import com.example.shoppinglist.domain.Item;
import com.example.shoppinglist.domain.ItemRepository;
import com.example.shoppinglist.domain.User;
import com.example.shoppinglist.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ShoppinglistApplication {
	private static final Logger logger = LoggerFactory.getLogger(
			ShoppinglistApplication.class
	);
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;

    public ShoppinglistApplication(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
	}

    public static void main(String[] args) {
		SpringApplication.run(ShoppinglistApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserRepository userRepository, ItemRepository itemRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// 테스트용 user 생성
			User user = new User("user", passwordEncoder.encode("user"), "USER");
			userRepository.save(user);
			User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN");
			userRepository.save(admin);

			// 테스트용 to-do 목록 생성
			itemRepository.save(new Item("아이패드", "2", user));
			itemRepository.save(new Item("맥북", "3", user));
		};
	}
}
