package com.example.cardatabase;

import com.example.cardatabase.domain.AppUser;
import com.example.cardatabase.domain.AppUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AppRepositoryTest {
    @Autowired
    private AppUserRepository userRepository;

    @Test
    @DisplayName("사용자 이름을 통한 조회")
    void findByUsernameReturnUser() {
        userRepository.save(new AppUser("user4","user","USER"));
        Optional<AppUser> foundUser = userRepository.findByUsername("user4");
        assertThat(userRepository.findByUsername("user4")).isPresent();
    }
}
