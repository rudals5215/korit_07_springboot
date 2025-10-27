package com.shoppinglist.shoppinglist2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

// Spring Data Rest에서 노출하지 않도록 설정.
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {

    // UserDetailsService 에서 사용할 수 있도록 미리 추상 메서드 정의.
    Optional<User> findByUsername(String username);
}
