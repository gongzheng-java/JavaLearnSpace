package com.dubbo.provider;

import java.io.IOException;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��3��9�� ����6:06:34
 * @Description:
 */
public class Main {
	public static void main(String[] args) throws IOException {
		com.alibaba.dubbo.container.Main.main(args);
		Main.main(args);
		System.out.println("�ɹ�����");
		System.in.read();
	}

}
