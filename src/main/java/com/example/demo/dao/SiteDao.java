package com.example.demo.dao;

import com.example.demo.Entity.Site;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiteDao {

    List<Site> findAll();

    Site findById(Integer id);

}
