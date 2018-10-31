package com.example.demo.controller;

import com.example.demo.Entity.Apply;
import com.example.demo.dao.SiteDao;
import com.example.demo.service.ApplyService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("apply")
public class ApplyController {

    @Autowired
    private SiteDao siteDao;
    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Map<String, Object>> getList(HttpServletRequest request) {
        Map<String, Object> params = new HashMap();
        if (null != request.getParameter("likeName")) {
            params.put("likeName", request.getParameter("likeName"));
        }
        if (null != request.getParameter("siteId")) {
            params.put("siteId", request.getParameter("siteId"));
        }
        return applyService.getList(params);
    }


    // 为支持ajax跨域
    @RequestMapping(value = "ajax/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getListByAjax(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap();
        if (null != request.getParameter("likeName")) {
            params.put("likeName", request.getParameter("likeName"));
        }
        if (null != request.getParameter("siteId") && request.getParameter("siteId").length() > 0) {
            params.put("siteId", request.getParameter("siteId"));
        }
        String jsonpCallback = request.getParameter("callback");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        JSONObject jsonObject = new JSONObject();
        jsonObject.element("status", "ok");
        List<Map<String, Object>> res = applyService.getList(params);
        List<Map<String, String>> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Map<String, Object> map : res) {
            Map<String, String> m = new HashMap<>();
            m.put("id", map.get("id").toString());
            m.put("name", map.get("name").toString());
            m.put("time", sdf.format((map.get("etime"))));
            m.put("ename", map.get("ename").toString());
            m.put("address", map.get("address").toString());
            result.add(m);
        }
        jsonObject.element("result", result);
        jsonObject.element("sites", siteDao.findAll());
        return jsonpCallback + "(" + jsonObject + ")";
    }


    // CrossOrigin, 支持跨域
//    @CrossOrigin
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        Apply apply = new Apply();
        apply.setEvent1Id(Integer.valueOf(request.getParameter("event1Id")));
        apply.setEvent2Id(
               null!= request.getParameter("event2Id")?Integer.valueOf(request.getParameter("event2Id")):null);
        apply.setName(request.getParameter("name"));
        applyService.save(apply);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        JSONObject jsonObject = new JSONObject();
        jsonObject.element("status", "ok");
        return jsonObject;
    }
}
