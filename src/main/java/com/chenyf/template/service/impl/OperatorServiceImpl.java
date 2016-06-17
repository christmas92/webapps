package com.chenyf.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.chenyf.template.dao.OperatorMapper;
import com.chenyf.template.model.Operator;
import com.chenyf.template.service.intf.OperatorService;
import com.chenyf.template.util.PageManager;


@Service
public class OperatorServiceImpl implements OperatorService {
	
	@Autowired
	private OperatorMapper operatormapper;
	
	public Operator getOperator(String paramString) {
		return operatormapper.getOperatorById(paramString);
	}

	@Override
	public PageManager<Operator> getList(ModelMap model, PageManager<Operator> page) {
		page.setTotalRecords(this.operatormapper.countAll());
		page.setRecords(this.operatormapper.getList(page.getPageStartRow(), page.getPageRecords()));
		model.addAttribute("page", page);
		return page;
	}

}
