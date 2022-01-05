package com.hoangdo.pttk.api.controller;

import com.hoangdo.pttk.api.dto.Xe;
import com.hoangdo.pttk.api.dto.request.RentBikeDto;
import com.hoangdo.pttk.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/xe")
public class XeController {
    private final XeService xeService;

    @Autowired
    public XeController(XeService xeService) {
        this.xeService = xeService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<Xe> xes = xeService.getAll();
        return ResponseEntity.ok(xes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") String id) {
        Xe xe = xeService.getById(Long.parseLong(id));
        return ResponseEntity.ok(xe);
    }

    @PostMapping("rent-bike")
    public ResponseEntity<?> rentBike(@RequestBody() RentBikeDto req) throws Exception {
        xeService.rentBike(req.getUserId(), req);
        return ResponseEntity.ok("success");
    }
}
