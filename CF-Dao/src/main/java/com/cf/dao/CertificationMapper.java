package com.cf.dao;

import com.cf.beans.Certification;
import java.util.List;

public interface CertificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Certification record);

    Certification selectByPrimaryKey(Integer id);

    List<Certification> selectAll();

    int updateByPrimaryKey(Certification record);
}