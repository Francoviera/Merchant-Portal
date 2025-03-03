package com.backOffice_electric_cooperative.demo.infastructure.controllers;

import com.backOffice_electric_cooperative.demo.application.services.MerchantService;
import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant) {
        Merchant createMerchant= merchantService.newMerchant(merchant);
        return new ResponseEntity<>(createMerchant, HttpStatus.CREATED);
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable Long merchantId) {
        return merchantService.getMerchant(merchantId)
                .map(merchant -> new ResponseEntity<>(merchant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> merchants = merchantService.getAllMerchants();
        return new ResponseEntity<>(merchants, HttpStatus.OK);
    }
    @PutMapping("/{merchantId}")
    public ResponseEntity<Merchant> updateMerchant(@RequestBody Merchant merchant) {
        return merchantService.updateMerchant(merchant)
                .map(merchant1 -> new ResponseEntity<>(merchant1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{merchantId}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long merchantId) {
        if(merchantService.deleteMerchant(merchantId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
