package com.example.demo.dao;

import com.example.demo.Entity.Book;

public interface BookDao {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKeyWithBLOBs(Book record);

    int updateByPrimaryKey(Book record);
}