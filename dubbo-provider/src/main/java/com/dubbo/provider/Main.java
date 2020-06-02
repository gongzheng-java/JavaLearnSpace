package com.dubbo.provider;

import java.io.IOException;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年3月9日 下午6:06:34
 * @Description:
 */
public class Main {
	public static void main(String[] args) throws IOException {
		com.alibaba.dubbo.container.Main.main(args);
		Main.main(args);
		System.out.println("成功！！");
		System.in.read();
	}

}
