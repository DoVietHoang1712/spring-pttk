package com.hoangdo.pttk.database.repository;

import com.hoangdo.pttk.database.entity.LichSuThueXeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuThueXeRepository extends JpaRepository<LichSuThueXeEntity, Long> {
}
