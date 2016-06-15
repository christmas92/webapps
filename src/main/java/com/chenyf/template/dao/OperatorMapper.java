package com.chenyf.template.dao;

import org.apache.ibatis.annotations.Param;

import com.chenyf.template.model.Operator;

public interface OperatorMapper {
	Operator getOperatorById(@Param("operatorId") String operatorId);
}