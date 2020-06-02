package com.log4j.test;

import org.apache.log4j.Logger;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年2月11日   下午3:28:49 
 * @Description:
 */
public class Log4jTest {
	
	public static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		logger.trace("我是logger1，trace");
		logger.debug("我是logger1，debug");
		logger.info("我是logger1，info");
		logger.warn("我是logger1，warn");
		logger.error("我是logger1，error");
		logger.fatal("我是logger1，fatal");
		

	}

}
