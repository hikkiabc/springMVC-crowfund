package com.cf.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static boolean isEmpty(Object s){
        return s==null||"".equals(s);
    }
//    public static Map createResponse(...agrs)
    public static Map resMap(){
       return new HashMap<String,Object>();
    }

}
