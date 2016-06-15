package com.chenyf.template.service;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.chenyf.template.service.intf.OperatorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:zfl-db.xml"})


public class OperatorServiceTest {
	private static final Logger logger = Logger.getLogger(OperatorServiceTest.class);
	
	@Autowired
	private OperatorService operatorservice = null;
	
	@Test
	public void getOperator(){
		logger.info(JSON.toJSON(operatorservice.getOperator("admin")));
	}  
	
}
