package com.example.demo.dao;

import com.example.demo.Entity.Chapter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChapterDao {
    int deleteByPrimaryKey(Long id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}