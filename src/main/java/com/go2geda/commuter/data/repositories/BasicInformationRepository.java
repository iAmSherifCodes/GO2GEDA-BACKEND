package com.go2geda.commuter.data.repositories;

import com.go2geda.commuter.data.model.BasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasicInformationRepository extends JpaRepository<BasicInformation, Long> {
    Optional<BasicInformation> findByEmail(String email);

}
