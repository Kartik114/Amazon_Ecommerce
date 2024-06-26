package org.oril.repository;

import org.oril.entities.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserVO,Integer> {
     public List<UserVO> findByEmail(String email);
}
