package com.barney.encyptionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/11/2019 4:05 PM
 */
@Data
@ToString//todo remove message and salt
@AllArgsConstructor
@NoArgsConstructor
public class HashEntity {

    private String message;
    private String salt;
    private String algorithm;
    private String digest;
}
