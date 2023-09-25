package com.go2geda.user.data.repository;

import com.go2geda.user.data.model.BasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasicInformationRepository extends JpaRepository<BasicInformation, Long> {
    Optional<BasicInformation> findByEmail(String email);

}
