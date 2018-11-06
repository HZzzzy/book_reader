package com.example.demo.dao;

import com.example.demo.Entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectById(Long id);

    List<Book> findList(Book book);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKeyWithBLOBs(Book record);

    int updateByPrimaryKey(Book record);
}