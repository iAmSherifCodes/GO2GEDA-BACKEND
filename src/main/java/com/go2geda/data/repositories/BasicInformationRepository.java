package com.go2geda.data.repositories;

import com.go2geda.data.model.BasicInformation;
import com.go2geda.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasicInformationRepository extends JpaRepository<BasicInformation, Long> {
    Optional<BasicInformation> findByEmail(String email);

}
