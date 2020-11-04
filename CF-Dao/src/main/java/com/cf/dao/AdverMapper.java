package com.cf.dao;

import com.cf.beans.Adver;
import java.util.List;
import java.util.Map;

public interface AdverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adver record);

    Adver selectByPrimaryKey(Integer id);

    List<Adver> selectAll();

    int updateByPrimaryKey(Adver record);

    List queryPages(Map<String, Object> map);

    Integer queryTotalCount(Map<String, Object> map);
}