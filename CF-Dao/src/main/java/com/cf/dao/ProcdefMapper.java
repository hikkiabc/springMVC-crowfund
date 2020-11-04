package com.cf.dao;

import com.cf.beans.Procdef;

import java.util.List;
import java.util.Map;

public interface ProcdefMapper {
    int deleteByPrimaryKey(String id);

    int insert(Procdef record);

    Procdef selectByPrimaryKey(String id);

    List<Procdef> selectAll();

    int updateByPrimaryKey(Procdef record);

    List queryPagesWithKeywords(Map<String, Object> map);

    Integer queryTotalCountWithKeywords(Map<String, Object> map);
}