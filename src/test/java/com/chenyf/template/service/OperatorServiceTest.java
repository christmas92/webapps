package com.chenyf.template.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;
import com.chenyf.template.model.Operator;
import com.chenyf.template.service.intf.OperatorService;
import com.chenyf.template.util.PageManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:zfl-db.xml"})


public class OperatorServiceTest {
	private static final Logger logger = Logger.getLogger(OperatorServiceTest.class);
	
	@Autowired
	private OperatorService operatorservice = null;
	
	@Test
	public void getOperator(){
		//logger.info(JSON.toJSON(operatorservice.getOperator("1")));
		PageManager<Operator> op = new PageManager<>();
		op.setCurrentPage(2);
		ModelMap map = new ModelMap();
		logger.info(JSON.toJSON(operatorservice.getList(map, op)));
	}  	
}
