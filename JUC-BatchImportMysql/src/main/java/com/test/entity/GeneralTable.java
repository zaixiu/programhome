package com.test.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GeneralTable implements Serializable {
    private String colValue;

    private String colAttr;

    private String colType;

    private String colFrom;

    private Long rowKey;

}


