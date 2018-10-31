package com.example.demo.dao;

import com.example.demo.Entity.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApplyDao {

    List<Map<String, Object>> findByParam(Map<String, Object> param);

    Apply findById(Integer id);

    void insertSelective(Apply apply);

}
