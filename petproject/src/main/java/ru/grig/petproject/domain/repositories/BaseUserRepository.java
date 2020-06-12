package ru.grig.petproject.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grig.petproject.domain.entities.BaseUser;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    Optional<BaseUser> findByUsername(String username);

}
