package com.go2geda.driver.data.repository;

import com.go2geda.driver.data.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query(value = """
            select d from Driver d
            where d.user.basicInformation.email = :email
            """)
    Optional<Driver> findDriverByEmail(String email);
}
