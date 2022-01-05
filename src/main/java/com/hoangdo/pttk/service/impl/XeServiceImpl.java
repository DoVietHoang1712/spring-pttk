package com.hoangdo.pttk.service.impl;

import com.hoangdo.pttk.api.dto.LichSuThueXe;
import com.hoangdo.pttk.api.dto.User;
import com.hoangdo.pttk.api.dto.Xe;
import com.hoangdo.pttk.api.dto.request.RentBikeDto;
import com.hoangdo.pttk.database.entity.*;
import com.hoangdo.pttk.database.repository.*;
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
    private final LichSuGiaoDichRepository lichSuGiaoDichRepository;
    private final LichSuThueXeRepository lichSuThueXeRepository;
    private final UserRepository userRepository;
    private final PromotionRepository promotionRepository;
    @Autowired
    public XeServiceImpl(XeRepository xeRepository, LichSuGiaoDichRepository lichSuGiaoDichRepository,
                         LichSuThueXeRepository lichSuThueXeRepository, UserRepository userRepository,
                         PromotionRepository promotionRepository) {
        this.xeRepository = xeRepository;
        this.lichSuGiaoDichRepository = lichSuGiaoDichRepository;
        this.lichSuThueXeRepository = lichSuThueXeRepository;
        this.userRepository = userRepository;
        this.promotionRepository = promotionRepository;
    }
    @Override
    public List<Xe> getAll() {
        return xeRepository.findAll().stream().map(x -> (Xe)x).collect(Collectors.toList());
    }

    @Override
    public Xe getById(Long id) {
        return xeRepository.getById(id);
    }

    @Override
    public void rentBike(Long userId, RentBikeDto req) throws Exception {
        UserEntity user = userRepository.getById(userId);
        XeEntity xe = xeRepository.getById(req.getXeId());
        Double price = 0.0;
        if (req.getType().equals("hour")) {
            price = req.getNumsOfRent() * xe.getPricePerHour();
        } else if (req.getType().equals("day")) {
            price = req.getNumsOfRent() * xe.getPricePerDay();
        }

        if (req.getPromotionId() != null) {
            PromotionEntity promotionEntity = promotionRepository.getById(req.getPromotionId());
            Double discountMax = promotionEntity.getDiscountPercent() / 100 * price + price;
            if (discountMax > promotionEntity.getDiscountMax()) {
                price -= promotionEntity.getDiscountMax();
            } else price -= discountMax;
        }

        if (price > user.getSoDuTaiKhoan()) {
            throw new Exception("Do not enough money");
        }

        LichSuGiaoDichEntity lichSuGiaoDichEntity = new LichSuGiaoDichEntity();
        LichSuThueXeEntity lichSuThueXeEntity = new LichSuThueXeEntity();
        user.setSoDuTaiKhoan(user.getSoDuTaiKhoan() - price);
        List<LichSuThueXe> list = lichSuThueXeRepository.findAllByIdXe(xe.getId());
        for (LichSuThueXe lichSuThueXe : list) {
            if ((req.getRentDate().after(lichSuThueXe.getNgayThueXe()) && req.getRentDate().before(lichSuThueXe.getNgayTraXe()))
            || (req.getReturnDate().after(lichSuThueXe.getNgayTraXe()) && req.getReturnDate().before(lichSuThueXe.getNgayTraXe()))
            ) {
                throw new Exception("Bike has rent");
            }
        }

        if (xe.getTrangThai().equals("rented")) {
            throw new Exception("Bike has rented");
        }
        userRepository.save(user);
        xe.setTrangThai("rented");
        xeRepository.save(xe);
        lichSuThueXeEntity.setIdKhachHang(userId);
        lichSuThueXeEntity.setIdXe(xe.getId());
        lichSuThueXeEntity.setNgayThueXe(req.getRentDate());
        lichSuThueXeEntity.setNgayTraXe(req.getReturnDate());
        lichSuThueXeEntity.setType(req.getType());
        lichSuThueXeEntity.setThoiGian(req.getNumsOfRent());
        lichSuGiaoDichEntity.setIdKhachHang(userId);
        lichSuGiaoDichEntity.setIdPromotion(req.getPromotionId());
        lichSuGiaoDichEntity.setSoTien(price);
        lichSuGiaoDichRepository.save(lichSuGiaoDichEntity);
        lichSuThueXeEntity.setLichSuGiaoDich(lichSuGiaoDichEntity);
        lichSuThueXeRepository.save(lichSuThueXeEntity);
    }
}
