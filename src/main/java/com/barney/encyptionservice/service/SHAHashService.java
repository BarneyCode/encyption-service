package com.barney.encyptionservice.service;

import com.barney.encyptionservice.model.HashEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/11/2019 4:01 PM
 */
@Service
@Slf4j
public class SHAHashService implements HashService {
    @Override
    public String hash(HashEntity hashEntity) {
        try {
            log.info(hashEntity.toString());
            MessageDigest messageDigest = MessageDigest.getInstance(getAlgorithm(hashEntity));
            messageDigest.update(hashEntity.getSalt().getBytes());
            byte[] hash = messageDigest.digest(hashEntity.getMessage().getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            log.debug(e.getLocalizedMessage());
            return e.getMessage();
        }
    }

    private String getAlgorithm(HashEntity hashEntity) {
        return hashEntity.getAlgorithm() + "-" + hashEntity.getDigest();
    }
}
