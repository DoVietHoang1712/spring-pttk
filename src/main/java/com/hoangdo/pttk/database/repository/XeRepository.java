package com.hoangdo.pttk.database.repository;

import com.hoangdo.pttk.database.entity.XeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends JpaRepository<XeEntity, Long> {
}
