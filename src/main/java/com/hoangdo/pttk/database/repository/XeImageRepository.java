package com.hoangdo.pttk.database.repository;

import com.hoangdo.pttk.database.entity.XeImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeImageRepository extends JpaRepository<XeImageEntity, Long> {
}
