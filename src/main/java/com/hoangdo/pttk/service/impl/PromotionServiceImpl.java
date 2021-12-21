package com.hoangdo.pttk.service.impl;

import com.hoangdo.pttk.api.dto.Promotion;
import com.hoangdo.pttk.database.repository.PromotionRepository;
import com.hoangdo.pttk.service.PromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;
    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }
    @Override
    public List<Promotion> getAllPromotion() {
        return promotionRepository.findAll().stream().map(i -> (Promotion)i).collect(Collectors.toList());
    }
}
