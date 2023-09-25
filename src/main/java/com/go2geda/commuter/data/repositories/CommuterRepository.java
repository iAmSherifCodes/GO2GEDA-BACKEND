package com.go2geda.commuter.data.repositories;

import com.go2geda.commuter.data.model.Commuter;
import com.go2geda.user.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommuterRepository extends JpaRepository<Commuter,Long> {

}
