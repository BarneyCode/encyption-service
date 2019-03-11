package com.barney.encyptionservice.controller;

import com.barney.encyptionservice.model.HashEntity;
import com.barney.encyptionservice.service.HashService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/10/2019 6:15 PM
 */
@RestController
public class HashController {

    private HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @GetMapping("/hash")
    public ResponseEntity<String> getSHA256Hash(@RequestBody HashEntity hashEntity){
        return ResponseEntity.ok(this.hashService.hash(hashEntity));
    }
}
