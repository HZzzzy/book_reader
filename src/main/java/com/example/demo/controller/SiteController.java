package com.example.demo.controller;

import com.example.demo.Entity.Site;
import com.example.demo.dao.SiteDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("site")
public class SiteController {

    @Autowired
    private SiteDao siteDao;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Site> getList() {
        List<Site> sites = new ArrayList<>();
        Site site = new Site();
        site.setId(1);
        site.setAddress("aaa");
        sites.add(site);
        sites = siteDao.findAll();
        return sites;
    }


    @RequestMapping(value = "ajax/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getListByAjax(HttpServletRequest request, HttpServletResponse response) {
        String jsonpCallback = request.getParameter("callback");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        JSONObject jsonObject = new JSONObject();
        jsonObject.element("status", "ok");
        jsonObject.element("result", siteDao.findAll());
        return jsonpCallback + "(" + jsonObject + ")";
    }
}
