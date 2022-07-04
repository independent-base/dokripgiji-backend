package com.dokripgiji.web.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUserId(Long userId);
    Optional<User> findByEmail(String email);

}

