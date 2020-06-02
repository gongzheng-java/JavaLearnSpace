package com.gongzheng.app;

import javax.transaction.Transactional;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年1月11日   下午8:22:09
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BookShopApplication.class)
@Transactional
public class BaseTest {

}
