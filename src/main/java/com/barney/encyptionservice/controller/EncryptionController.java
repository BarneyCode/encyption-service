package com.barney.encyptionservice.controller;

import com.barney.encyptionservice.model.EncryptionEntity;
import com.barney.encyptionservice.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/10/2019 6:15 PM
 */
@RestController
public class EncryptionController {

    private EncryptionService encryptionService;

    @Autowired
    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @GetMapping("/encrypt")
    public String encrypt(@RequestBody EncryptionEntity encryptionEntity){
        return this.encryptionService.encrypt(encryptionEntity);
    }

    @GetMapping("/aes/decrypt")
    public String decrypt(@RequestBody EncryptionEntity encryptionEntity){
        return this.encryptionService.decrypt(encryptionEntity);
    }
}
