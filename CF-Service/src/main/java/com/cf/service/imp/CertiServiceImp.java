package com.cf.service.imp;

import com.cf.dao.CertificationMapper;
import com.cf.service.CertiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertiServiceImp  implements CertiService {
    @Autowired
    CertificationMapper certificationMapper;
    @Override
    public List queryAll() {
        return certificationMapper.selectAll();
    }
}
