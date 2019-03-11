package com.barney.encyptionservice.service;

import com.barney.encyptionservice.constants.Constants;
import com.barney.encyptionservice.model.EncryptionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/10/2019 6:23 PM
 */
@Service
@Slf4j
public class AESEncryptionService implements EncryptionService {
    @Override
    public String encrypt(EncryptionEntity encryptionEntity) {
        try {
            log.info(encryptionEntity.toString());
            IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionEntity.getIv().getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionEntity.getKey().getBytes(StandardCharsets.UTF_8), encryptionEntity.getAlgorithm());
            Cipher cipher = Cipher.getInstance(Constants.ALGORITHM_AES_CBC);
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,ivParameterSpec);
            byte[] encrypted = cipher.doFinal(encryptionEntity.getValue().getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    public String decrypt(EncryptionEntity encryptionEntity) {
        try {
            log.info(encryptionEntity.toString());
            IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionEntity.getIv().getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionEntity.getKey().getBytes(StandardCharsets.UTF_8), encryptionEntity.getAlgorithm());
            Cipher cipher = Cipher.getInstance(Constants.ALGORITHM_AES_CBC);
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,ivParameterSpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptionEntity.getValue()));
            return new String(decrypted);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
    }
}
