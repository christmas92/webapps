package com.chenyf.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenyf.template.dao.OperatorMapper;
import com.chenyf.template.model.Operator;
import com.chenyf.template.service.intf.OperatorService;


@Service
public class OperatorServiceImpl implements OperatorService {
	
	@Autowired
	private OperatorMapper operatormapper;
	
	public Operator getOperator(String paramString) {
		return operatormapper.getOperatorById(paramString);
	}

}
