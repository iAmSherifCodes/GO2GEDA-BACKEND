package com.go2geda.driver.data.repository;

import com.go2geda.driver.data.model.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepository extends JpaRepository<Fleet,Long> {
}
