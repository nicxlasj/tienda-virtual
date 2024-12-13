package com.nico.tienda_virtual.web.controller;

import com.nico.tienda_virtual.domain.dto.Purchase;
import com.nico.tienda_virtual.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<List<Purchase>>> getByUser(@PathVariable int userId) {
        return new ResponseEntity<>(purchaseService.getByUser(userId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        purchaseService.save(purchase);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
