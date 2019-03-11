package com.barney.encyptionservice.service;

import com.barney.encyptionservice.model.EncryptionEntity;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/10/2019 6:23 PM
 */

public interface EncryptionService {

    String encrypt(EncryptionEntity encryptionEntity);
    String decrypt(EncryptionEntity encryptionEntity);
}
