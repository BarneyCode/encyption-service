package com.barney.encyptionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/10/2019 6:55 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString//todo remove all
public class EncryptionEntity {

    private String key;//128 byte key
    private String value;//string value
    private String iv;//16 byte iv
    private String algorithm;//16 byte iv
}
