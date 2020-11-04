package com.cf.service;

import com.cf.beans.Page;

import java.util.Map;

public interface ProcdefService {
    Page queryPages(Map<String, Object> map);
}
