package com.example.demo.service;

import com.example.demo.Entity.Apply;
import com.example.demo.dao.ApplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApplyService {
    @Autowired
    private ApplyDao applyDao;

    public List<Map<String, Object>> getList(Map<String, Object> params) {
        return applyDao.findByParam(params);
    }

    public void save(Apply apply) {
        applyDao.insertSelective(apply);
    }
}
