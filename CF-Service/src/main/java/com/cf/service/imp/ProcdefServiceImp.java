package com.cf.service.imp;

import com.cf.beans.Page;
import com.cf.dao.ProcdefMapper;
import com.cf.service.ProcdefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProcdefServiceImp implements ProcdefService {
    @Autowired
    ProcdefMapper procdefMapper;
    @Override
    public Page queryPages(Map<String, Object> map) {
        Integer pageNum= (Integer) map.get("pageNum");
        Integer pageSize= (Integer) map.get("pageSize");
        Integer skip=(pageNum-1)*pageSize;
        map.replace("pageNum",skip);
       List data= procdefMapper.queryPagesWithKeywords(map);
       Integer totalCount =procdefMapper.queryTotalCountWithKeywords(map);
        Integer totalPages=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        if (totalCount<pageSize) pageSize=totalCount;
        Page page = new Page(pageNum, pageSize, totalCount, totalPages, data);

        return page;
    }
}
