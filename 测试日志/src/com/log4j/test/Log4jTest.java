package com.log4j.test;

import org.apache.log4j.Logger;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��2��11��   ����3:28:49 
 * @Description:
 */
public class Log4jTest {
	
	public static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		logger.trace("����logger1��trace");
		logger.debug("����logger1��debug");
		logger.info("����logger1��info");
		logger.warn("����logger1��warn");
		logger.error("����logger1��error");
		logger.fatal("����logger1��fatal");
		

	}

}
