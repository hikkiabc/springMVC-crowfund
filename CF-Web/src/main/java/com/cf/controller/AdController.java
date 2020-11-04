package com.cf.controller;

import com.cf.beans.Adver;
import com.cf.beans.Page;
import com.cf.beans.User;
import com.cf.service.AdverService;
import com.cf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/ad")
@Controller
public class AdController {
    @Autowired
    AdverService adverService;

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "ad/index";
    }

    @ResponseBody
    @RequestMapping("/queryPages")
    public Object queryPages(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize,
                             String keywords) {
        Map resMap = Utils.resMap();

        Map<String, Object> map = new HashMap<>();
        if (!Utils.isEmpty(keywords)) {
            if (keywords.contains("%")) keywords = keywords.replaceAll("%", "\\\\%");
            map.put("keywords", keywords);
        }
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);

        try {
          Page  page = adverService.queryPages(map);
            resMap.put("res",page);

        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res","fail");
        }
        return resMap;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "ad/add";
    }
    @RequestMapping("/add")
    @ResponseBody
    public Object add(HttpServletRequest request, Adver adver, HttpSession httpSession) throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        MultipartHttpServletRequest multi= (MultipartHttpServletRequest) request;

        MultipartFile file = multi.getFile("file");
        if(!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();
            String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
            String iconpath= UUID.randomUUID().toString()+extname;
            String realPath = httpSession.getServletContext().getRealPath("/upload");
            String path=realPath+"\\pics"+iconpath;
            file.transferTo(new File(path));
            adver.setIconpath(iconpath);
        }
        User user = (User) httpSession.getAttribute("user");

        adver.setUserid(user.getId());
adver.setStatus(1);
        Map resMap = Utils.resMap();
        try {
            int res=adverService.insert(adver);
            resMap.put("res",res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resMap;
    }
}
