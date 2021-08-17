package com.app.web.repos;

import com.app.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReporsitory extends JpaRepository<User, Long> {

    Optional<User> findByLoginId(String loginId);

}
