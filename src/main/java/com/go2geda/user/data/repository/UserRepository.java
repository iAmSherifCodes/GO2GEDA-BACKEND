package com.go2geda.user.data.repository;

import com.go2geda.driver.data.model.Driver;
import com.go2geda.user.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByBasicInformation_Id(Long basicInfoId);

    @Query(value = """
            select d from User d
            where d.basicInformation.email = :email
            """)
    Optional<User> findUserByEmail(String email);

}
