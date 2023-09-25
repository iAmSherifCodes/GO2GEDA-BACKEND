package com.go2geda.driver.data.repository;

import com.go2geda.driver.data.model.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverInformationRepository extends JpaRepository<DriverInformation,Long> {
}
