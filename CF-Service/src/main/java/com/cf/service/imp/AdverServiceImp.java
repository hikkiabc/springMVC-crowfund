package com.cf.service.imp;

import com.cf.beans.Adver;
import com.cf.beans.Page;
import com.cf.dao.AdverMapper;
import com.cf.service.AdverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdverServiceImp implements AdverService {
    @Autowired
    AdverMapper adverMapper;

    @Override
    public Page queryPages(Map<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer skip = (pageNum - 1) * pageSize;
        map.replace("pageNum", skip);
        List data = adverMapper.queryPages(map);
        Integer totalCount = adverMapper.queryTotalCount(map);
        Integer totalPages = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        if (pageSize > totalCount) pageSize = totalCount;
        Page page = new Page(pageNum, pageSize, totalCount, totalPages, data);

        return page;
    }

    @Override
    public int insert(Adver adver) {
        return adverMapper.insert(adver);
    }
}
