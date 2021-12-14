package com.hoangdo.pttk.database.repository;

import com.hoangdo.pttk.api.dto.User;
import com.hoangdo.pttk.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
