package com.cf.service;

import com.cf.beans.AccType_Certi;

import java.util.List;
import java.util.Map;

public interface AccType_CertiService {
    List<Map<String, Object>> queryAll();

    Integer insert(AccType_Certi accType_certi);

    Integer delete(AccType_Certi accType_certi);
}
