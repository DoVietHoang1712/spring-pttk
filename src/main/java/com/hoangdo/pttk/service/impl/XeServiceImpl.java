package com.hoangdo.pttk.service.impl;

import com.hoangdo.pttk.api.dto.Xe;
import com.hoangdo.pttk.database.entity.XeEntity;
import com.hoangdo.pttk.database.repository.XeRepository;
import com.hoangdo.pttk.service.XeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class XeServiceImpl implements XeService {
    private final XeRepository xeRepository;
    @Autowired
    public XeServiceImpl(XeRepository xeRepository) {
        this.xeRepository = xeRepository;
    }
    @Override
    public List<Xe> getAll() {
        return xeRepository.findAll().stream().map(x -> (Xe)x).collect(Collectors.toList());
    }

    @Override
    public Xe getById(Long id) {
        return xeRepository.getById(id);
    }
}
