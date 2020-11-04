package com.cf.dao;

import com.cf.beans.AccType_Certi;
import java.util.List;
import java.util.Map;

public interface AccType_CertiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccType_Certi record);

    AccType_Certi selectByPrimaryKey(Integer id);

    List<AccType_Certi> selectAll();

    int updateByPrimaryKey(AccType_Certi record);

    List<Map<String, Object>> queryAccTypeAndCertiId();

    Integer delete(AccType_Certi accType_certi);
}