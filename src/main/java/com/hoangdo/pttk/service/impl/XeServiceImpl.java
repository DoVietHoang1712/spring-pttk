package com.hoangdo.pttk.service.impl;

import com.hoangdo.pttk.api.dto.User;
import com.hoangdo.pttk.api.dto.Xe;
import com.hoangdo.pttk.api.dto.request.RentBikeDto;
import com.hoangdo.pttk.database.entity.LichSuGiaoDichEntity;
import com.hoangdo.pttk.database.entity.LichSuThueXeEntity;
import com.hoangdo.pttk.database.entity.UserEntity;
import com.hoangdo.pttk.database.entity.XeEntity;
import com.hoangdo.pttk.database.repository.LichSuGiaoDichRepository;
import com.hoangdo.pttk.database.repository.LichSuThueXeRepository;
import com.hoangdo.pttk.database.repository.UserRepository;
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
    private final LichSuGiaoDichRepository lichSuGiaoDichRepository;
    private final LichSuThueXeRepository lichSuThueXeRepository;
    private final UserRepository userRepository;
    @Autowired
    public XeServiceImpl(XeRepository xeRepository, LichSuGiaoDichRepository lichSuGiaoDichRepository, LichSuThueXeRepository lichSuThueXeRepository, UserRepository userRepository) {
        this.xeRepository = xeRepository;
        this.lichSuGiaoDichRepository = lichSuGiaoDichRepository;
        this.lichSuThueXeRepository = lichSuThueXeRepository;
        this.userRepository = userRepository;
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

        if (price > user.getSoDuTaiKhoan()) {
            throw new Exception("Do not enough money");
        }

        LichSuGiaoDichEntity lichSuGiaoDichEntity = new LichSuGiaoDichEntity();
        LichSuThueXeEntity lichSuThueXeEntity = new LichSuThueXeEntity();
        user.setSoDuTaiKhoan(user.getSoDuTaiKhoan() - price);
        userRepository.save(user);
        xe.setTrangThai("rented");
        xeRepository.save(xe);
        lichSuThueXeEntity.setIdKhachHang(userId);
        lichSuThueXeEntity.setIdXe(xe.getId());
        lichSuThueXeEntity.setNgayThueXe(req.getRentDate());
        lichSuThueXeEntity.setThoiGian(req.getNumsOfRent());
        lichSuGiaoDichEntity.setIdKhachHang(userId);
        lichSuGiaoDichEntity.setIdPromotion(req.getPromotionId());
        lichSuGiaoDichEntity.setSoTien(price);
        lichSuThueXeEntity.setLichSuGiaoDich(lichSuGiaoDichEntity);
        lichSuThueXeRepository.save(lichSuThueXeEntity);

    }
}
