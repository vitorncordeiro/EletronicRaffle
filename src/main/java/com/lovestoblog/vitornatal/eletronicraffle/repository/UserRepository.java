package com.lovestoblog.vitornatal.eletronicraffle.repository;

import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserDetails> findByEmail(String email);
}
