package com.cf.service;

import com.cf.beans.Adver;
import com.cf.beans.Page;

import java.util.Map;

public interface AdverService {
    Page queryPages(Map<String, Object> map);

    int insert(Adver adver);
}
