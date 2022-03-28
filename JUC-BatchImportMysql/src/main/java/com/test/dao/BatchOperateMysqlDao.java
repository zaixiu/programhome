package com.test.dao;

import com.test.entity.GeneralTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BatchOperateMysqlDao {
    /**
     * 批量插入数据库
     * @param list
     */
    void batchInsert(@Param("list") List<GeneralTable> list);



}
