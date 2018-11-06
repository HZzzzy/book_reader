package com.example.demo.dao;

import com.example.demo.Entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}