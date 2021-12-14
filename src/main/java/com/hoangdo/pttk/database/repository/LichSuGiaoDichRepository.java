package com.hoangdo.pttk.database.repository;

import com.hoangdo.pttk.database.entity.LichSuGiaoDichEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuGiaoDichRepository extends JpaRepository<LichSuGiaoDichEntity, Long> {
}
