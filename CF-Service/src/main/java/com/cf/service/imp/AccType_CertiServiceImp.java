package com.cf.service.imp;

import com.cf.beans.AccType_Certi;
import com.cf.dao.AccType_CertiMapper;
import com.cf.service.AccType_CertiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccType_CertiServiceImp implements AccType_CertiService {
    @Autowired
    AccType_CertiMapper accType_certiMapper;
    @Override
    public List<Map<String, Object>> queryAll() {
        return accType_certiMapper.queryAccTypeAndCertiId();
    }

    @Override
    public Integer insert(AccType_Certi accType_certi) {
        return accType_certiMapper.insert(accType_certi);
    }

    @Override
    public Integer delete(AccType_Certi accType_certi) {
        return accType_certiMapper.delete(accType_certi);
    }
}
