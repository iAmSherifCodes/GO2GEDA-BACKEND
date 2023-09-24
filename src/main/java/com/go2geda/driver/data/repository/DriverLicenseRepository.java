package com.go2geda.driver.data.repository;

import com.go2geda.driver.data.model.DriverLicence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLicenseRepository extends JpaRepository<DriverLicence,Long> {
}
