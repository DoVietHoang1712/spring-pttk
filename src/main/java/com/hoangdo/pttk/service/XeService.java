package com.hoangdo.pttk.service;

import com.hoangdo.pttk.api.dto.Xe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface XeService {
    List<Xe> getAll();
    Xe getById(Long id);

}
