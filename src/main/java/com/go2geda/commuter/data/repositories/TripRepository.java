package com.go2geda.commuter.data.repositories;

import com.go2geda.commuter.data.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TripRepository extends JpaRepository<Trip,Long> {
}
