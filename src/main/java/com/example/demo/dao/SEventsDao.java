package com.example.demo.dao;

import com.example.demo.Entity.SEvents;
import com.example.demo.Entity.Site;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SEventsDao {

    List<SEvents> findAll();

    Site findById(Integer id);

}
