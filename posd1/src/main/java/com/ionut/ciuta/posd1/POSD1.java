package com.ionut.ciuta.posd1;

import com.ionut.ciuta.posd1.model.Permission;
import com.ionut.ciuta.posd1.model.sql.Role;
import com.ionut.ciuta.posd1.model.sql.User;
import com.ionut.ciuta.posd1.repository.RoleRepository;
import com.ionut.ciuta.posd1.repository.UserRepository;
import com.ionut.ciuta.posd1.service.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class POSD1 {
	private static final Logger log = LoggerFactory.getLogger(POSD1.class);

	@Autowired
	private Storage storage;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(POSD1.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStart() {
		log.info("Storage users: {}", storage.getUsers());
		log.info("Storage resources: {}", storage.getResources());
		setupUsers();
	}

	private void setupUsers() {
		userRepository.save(new User("root", "root"));
		userRepository.save(new User("alice", "alice"));
		userRepository.save(new User("bob", "bob"));
	}

	private void setupRoles() {
		roleRepository.save(new Role("owner", Permission.RW));
	}
}
