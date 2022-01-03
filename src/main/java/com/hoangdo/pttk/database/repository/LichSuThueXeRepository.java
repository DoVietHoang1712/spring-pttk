package com.hoangdo.pttk.database.repository;

import com.hoangdo.pttk.api.dto.LichSuThueXe;
import com.hoangdo.pttk.database.entity.LichSuThueXeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichSuThueXeRepository extends JpaRepository<LichSuThueXeEntity, Long> {
    List<LichSuThueXe> findAllByIdXe(Long xeId);
}
