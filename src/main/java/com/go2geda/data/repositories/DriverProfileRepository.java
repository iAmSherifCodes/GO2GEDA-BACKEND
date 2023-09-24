package com.go2geda.data.repositories;

import com.go2geda.data.model.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverProfileRepository extends JpaRepository<DriverInformation,Long> {
}
