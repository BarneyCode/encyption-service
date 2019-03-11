package com.barney.encyptionservice.service;

import com.barney.encyptionservice.model.HashEntity;

/**
 * Project  : encyption-service
 * Developer: katakwab
 * Date     : 3/11/2019 3:59 PM
 */

public interface HashService {

    String hash(HashEntity hashEntity);
}
