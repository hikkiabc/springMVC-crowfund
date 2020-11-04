package com.cf.controller;

import com.cf.beans.Page;
import com.cf.service.ProcdefService;
import com.cf.utils.Utils;
import jdk.jshell.execution.Util;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RequestMapping("/process")
@Controller
public class ProcessController {
    @Autowired
    ProcdefService procdefService;
    @Autowired
    RepositoryService repositoryService;

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "process/index";
    }

    @ResponseBody
    @RequestMapping("/queryPages")
    public Object queryPages(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "4") Integer pageSize,
                             String keywords) {
//        System.out.println(1);
        Map resMap = Utils.resMap();
        Map<String, Object> map = new HashMap<>();
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);
        ArrayList<Map<String, Object>> dataList = new ArrayList<>();
        if (!Utils.isEmpty(keywords)) {
            if (keywords.contains("%")) keywords.replaceAll("%", "\\\\%");
            map.put("keywords", keywords);
        }
        try {
//            Page page= procdefService.queryPages(map);
            ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
            List<ProcessDefinition> processDefinitions = processDefinitionQuery.listPage((pageNum - 1) * pageSize, pageSize);
            Long count = processDefinitionQuery.count();
            for (ProcessDefinition processDefinition : processDefinitions) {
                Map<String, Object> map1 = new HashMap<>();
                map1.put("id", processDefinition.getId());
                map1.put("resourceName", processDefinition.getResourceName());
                dataList.add(map1);
            }


            Integer totalCount = count.intValue();
            Integer totalPages = (totalCount % pageSize) == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
            Page page = new Page(pageNum, pageSize, totalCount, totalPages, dataList);

            resMap.put("res", page);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res", "fail");
        }
        return resMap;
    }

    @ResponseBody
    @RequestMapping("/uploadProcess")
    public Object uploadProcess(HttpServletRequest request) throws IOException {
        Map resMap = Utils.resMap();
        MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
        MultipartFile file = multi.getFile("file");
        MultipartFile png = multi.getFile("png");


        if (!Utils.isEmpty(png)) {
            String pngOriginalFilename = png.getOriginalFilename();
            if (!Utils.isEmpty(file)) {
                String fileOriginalFilename = file.getOriginalFilename();

                try {
                    repositoryService.createDeployment().addInputStream(fileOriginalFilename, file.getInputStream())
                            .addInputStream(pngOriginalFilename, png.getInputStream()) .deploy();
                    resMap.put("res", "ok");
                } catch (IOException e) {
                    e.printStackTrace();
                    resMap.put("res", "fail");

                }
            } else {
                resMap.put("res", "lack of files");
            }
        } else {
            resMap.put("res", "no png");
        }
        return resMap;
    }

    @RequestMapping("/deleteProcess")
    @ResponseBody
    public Object deleteProcess(String id) {
        Map resMap = Utils.resMap();
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();

            repositoryService.deleteDeployment(processDefinition.getDeploymentId(), true);
            resMap.put("res", "ok");
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res", "fail");

        }
        return resMap;
    }
    @RequestMapping("/processPng")
    public String processPng(){
        return "/process/png";
    }
//    @ResponseBody
    @RequestMapping("/queryPng")
    public void queryPng(String id, HttpServletResponse response) throws IOException {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();
        InputStream is = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(is,outputStream);
    }
}
