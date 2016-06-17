package com.chenyf.template.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chenyf.template.model.Operator;

public interface OperatorMapper {
	Operator getOperatorById(@Param("operatorId") String operatorId);
	List<Operator> getOperatorAll();
	List<Operator> getList(@Param("startIndex") int startIndex,@Param("counts") int counts);
	int countAll();
}