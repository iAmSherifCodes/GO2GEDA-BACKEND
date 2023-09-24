package com.go2geda.data.repositories;

import com.go2geda.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByBasicInformation_Id(Long basicInfoId);

}
