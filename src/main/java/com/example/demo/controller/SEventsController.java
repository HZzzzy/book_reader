package com.example.demo.controller;

import com.example.demo.dao.SEventsDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("events")
public class SEventsController {

    @Autowired
    private SEventsDao sEventsDao;


    @RequestMapping(value = "ajax/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getListByAjax(HttpServletRequest request, HttpServletResponse response) {
        String jsonpCallback = request.getParameter("callback");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        JSONObject jsonObject = new JSONObject();
        jsonObject.element("status", "ok");
        jsonObject.element("result", sEventsDao.findAll());
        return jsonpCallback + "(" + jsonObject + ")";
    }
}
