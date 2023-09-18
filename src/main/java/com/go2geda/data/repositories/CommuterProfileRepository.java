package com.go2geda.data.repositories;

import com.go2geda.data.model.CommuterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuterProfileRepository extends JpaRepository<CommuterProfile,Long> {
}
