package com.cf.controller;

import com.cf.beans.AccType_Certi;
import com.cf.service.AccType_CertiService;
import com.cf.service.CertiService;
import com.cf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/certi")
@Controller
public class CertiController {
    @Autowired
    CertiService certiService;
    @Autowired
    AccType_CertiService accType_certiService;
    @RequestMapping("/toIndex")
    public String toIndex(Map map){

 List list= certiService.queryAll();
List<Map<String,Object>> accTypeCertiList= accType_certiService.queryAll();

map.put("list",list);
map .put("accTypeCertiList",accTypeCertiList);

        return "certi/index";
    }
    @ResponseBody
    @RequestMapping("/insertCertiAccType")
        public Object insertCertiAccType(AccType_Certi accType_certi){
            Map resMap = Utils.resMap();

            try {
                Integer res= accType_certiService.insert(accType_certi);
                resMap.put("res",res);
            } catch (Exception e) {
                e.printStackTrace();
                resMap.put("res","fail");

            }
            return resMap;
        }
    @ResponseBody
    @RequestMapping("/deleteCertiAccType")
    public Object deleteCertiAccType(AccType_Certi accType_certi){
        Map resMap = Utils.resMap();

        try {
            Integer res= accType_certiService.delete(accType_certi);
            resMap.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res","fail");

        }
        return resMap;
    }
}
