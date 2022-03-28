package com.test.service;

import com.test.entity.GeneralTable;

import java.util.List;

public interface BatchOperateMysqlInf {
    boolean insert(List<GeneralTable> list);


}
