package com.chenyf.template.service.intf;

import org.springframework.ui.ModelMap;

import com.chenyf.template.model.Operator;
import com.chenyf.template.util.PageManager;

public interface OperatorService {
	public Operator getOperator(String paramString);
	public PageManager<Operator> getList(ModelMap model,PageManager<Operator> page);
}
